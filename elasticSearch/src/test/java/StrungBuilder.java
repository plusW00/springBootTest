import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author wangjia
 * @Date 2022/4/27
 */
public class StrungBuilder {

    public static void main(String[] args) {

      /*  StringBuilder s = new StringBuilder();
        s.append(String.format("%-10s", "任务名陈" + "|"));
        s.append(String.format("%-10s", "任务时间" + "|"));
        s.append(String.format("%-10s", "占比" + "|\n"));
        s.append(String.format("%-10s", "ES" + "|"));*/


        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------\n");
        sb.append(String.format("%-9s", "task name")).append("| ");
        sb.append(String.format("%-9s", "task time")).append("| ");
        sb.append(String.format("%-10s", "percent")).append("|\n");
        sb.append("---------------------------------------------\n");

        sb.append(String.format("%-9s", "loaddata")).append("| ");
        sb.append(String.format("%-9s", "911.111s")).append("| ");
        sb.append(String.format("%-10s", "070%")).append("|\n");

        sb.append(String.format("%-9s", "ATLAS")).append("| ");
        sb.append(String.format("%-9s", "911.111s")).append("| ");
        sb.append(String.format("%-10s", "070%")).append("|\n");

        sb.append(String.format("%-9s", "ES")).append("| ");
        sb.append(String.format("%-9s", "3.121s")).append("| ");
        sb.append(String.format("%-10s", "070%")).append("|\n");

        System.out.println(sb);


    }


}
