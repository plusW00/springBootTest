import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * @Author wangjia
 * @Date 2022/4/27
 */
public class ConsoleTable {
    private Header header;
    private Body body;
    String lineSep = "\n";
    String verticalSep = "|";
    String horizontalSep = "-";
    String joinSep = "+";
    int[] columnWidths;
    NullPolicy nullPolicy = NullPolicy.EMPTY_STRING;
    boolean restrict = false;

    private ConsoleTable(){}

    void print() {
        System.out.println(getContent());
    }

    String getContent() {
        return toString();
    }

    List<String> getLines(){
        List<String> lines = new ArrayList<>();
        if((header != null && !header.isEmpty()) || (body != null && !body.isEmpty())){
            lines.addAll(header.print(columnWidths,horizontalSep,verticalSep,joinSep));
            lines.addAll(body.print(columnWidths,horizontalSep,verticalSep,joinSep));
        }
        return lines;
    }

    @Override
    public String toString() {
        return StringUtils.join(getLines(), lineSep);
    }

    public static class ConsoleTableBuilder {

        ConsoleTable consoleTable = new ConsoleTable();

        public ConsoleTableBuilder(){
            consoleTable.header = new Header();
            consoleTable.body = new Body();
        }

        public ConsoleTableBuilder addHeaders(List<Cell> headers){
            consoleTable.header.addHeads(headers);
            return this;
        }

        public ConsoleTableBuilder addRows(List<List<Cell>> rows){
            consoleTable.body.addRows(rows);
            return this;
        }


        public ConsoleTableBuilder verticalSep(String verticalSep){
            consoleTable.verticalSep = verticalSep;
            return this;
        }

        public ConsoleTable build(){
            //compute max column widths
            if(!consoleTable.header.isEmpty() || !consoleTable.body.isEmpty()){
                List<List<Cell>> allRows = new ArrayList<>();
                allRows.add(consoleTable.header.cells);
                allRows.addAll(consoleTable.body.rows);
                int maxColumn = allRows.stream().map(List::size).mapToInt(size -> size).max().getAsInt();
                int minColumn = allRows.stream().map(List::size).mapToInt(size -> size).min().getAsInt();
                if(maxColumn != minColumn && consoleTable.restrict){
                    throw new IllegalArgumentException("number of columns for each row must be the same when strict mode used.");
                }
                consoleTable.columnWidths = new int[maxColumn];
                for (List<Cell> row : allRows) {
                    for (int i = 0; i < row.size(); i++) {
                        Cell cell = row.get(i);
                        if(cell == null || cell.getValue() == null){
                            cell = consoleTable.nullPolicy.getCell(cell);
                            row.set(i,cell);
                        }
                        int length = StringPadUtil.strLength(cell.getValue());
                        if(consoleTable.columnWidths[i] < length){
                            consoleTable.columnWidths[i] = length;
                        }
                    }
                }
            }
            return consoleTable;
        }
    }


    public static void main(String[] args){
        List<Cell> header = new ArrayList<Cell>(){{
            add(new Cell("name"));
            add(new Cell("email"));
            add(new Cell("tel"));
        }};
        List<List<Cell>> body = new ArrayList<List<Cell>>(){{
            add(new ArrayList<Cell>(){{
                add(new Cell("kat"));
                add(new Cell(Align.CENTER,"kat@gimal.com"));
                add(new Cell(Align.RIGHT,"54321"));
            }});
            add(new ArrayList<Cell>(){{
                add(new Cell("ashe"));
                add(new Cell("ashe_111@hotmail.com"));
                add(new Cell("9876543????????????210"));
            }});
            add(new ArrayList<Cell>(){{
                add(null);
                add(new Cell(null));
                add(new Cell(Align.LEFT,"11"));
            }});
        }};
        //default
        new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).build().print();

        //??????
        header = new ArrayList<Cell>(){{
            add(new Cell("task name"));
            add(new Cell("task time"));
            add(new Cell("percent"));
        }};
        body = new ArrayList<List<Cell>>(){{
            add(new ArrayList<Cell>(){{
                add(new Cell(Align.CENTER, "loadData"));
                add(new Cell(Align.CENTER,"70092739.123s"));
                add(new Cell(Align.CENTER,"020%"));
            }});
            add(new ArrayList<Cell>(){{
                add(new Cell(Align.LEFT, "ATLAS"));
                add(new Cell(Align.CENTER, "28785767.121s"));
                add(new Cell(Align.CENTER,"090%"));
            }});
            add(new ArrayList<Cell>(){{
                add(new Cell(Align.LEFT, "ES"));
                add(new Cell(Align.CENTER, "1.123s"));
                add(new Cell(Align.CENTER,"079%"));
            }});
        }};
        new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).build().print();

        //no header
        //new ConsoleTable.ConsoleTableBuilder().addRows(body).build().print();

        //restrict
        //header.add(new Cell("not restrict"));
        //new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).restrict(false).build().print();
        //new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).restrict(true).build().print();

        //"null"
        //new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).nullPolicy(NullPolicy.NULL_STRING).build().print();
        //new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).nullPolicy(NullPolicy.THROW).build().print();

        //line sep
        //new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).lineSep("\n\n").build().print();

        //vertical sep & horizontal sep & join sep
        //new ConsoleTable.ConsoleTableBuilder().addHeaders(header).addRows(body).verticalSep("*").horizontalSep("*").joinSep("*").build().print();
    }




}
