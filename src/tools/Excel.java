package tools;

import java.io.File;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import models.model.Model;
import models.model.ResultOfDay;

public class Excel {

    public static void writeResult(File f, Model model) {

        try {
            WritableWorkbook books = Workbook.createWorkbook(f);
            WritableSheet sheet = books.createSheet("my sheet", 0);
            Label l = new Label(0, 0, "Model :");
            Label l1 = new Label(1, 0, model.getModelName());
            Label l2 = new Label(0, 1, "City : ");
            Label l3 = new Label(1, 1, model.getCity().getName());

            sheet.addCell(l);
            sheet.addCell(l1);
            sheet.addCell(l2);
            sheet.addCell(l3);

            Label l4 = new Label(0, 5, "Week");
            Label l5 = new Label(1, 5, "Day");
            Label l6 = new Label(2, 5, "Health");
            Label l7 = new Label(3, 5, "Immune");
            Label l8 = new Label(4, 5, "Death");

            sheet.addCell(l4);
            sheet.addCell(l5);
            sheet.addCell(l6);
            sheet.addCell(l7);
            sheet.addCell(l8);

            ResultOfDay re = model.getListResult().get(0);
            int index = 5;

            sheet.addCell(new Label(0, 6, re.getWeek() + ""));
            sheet.addCell(new Label(1, 6, re.getDayName()));
            sheet.addCell(new Label(2, 6, re.getHealth() + ""));
            sheet.addCell(new Label(3, 6, re.getImmune() + ""));
            sheet.addCell(new Label(4, 6, re.getDeath() + ""));
            for (Entry<String, Integer> e : re.getListStageResult().entrySet()) {
                Label ll = new Label(index, 5, e.getKey());
                Label lll = new Label(index, 6, e.getValue() + "");
                sheet.addCell(ll);
                sheet.addCell(lll);
                index++;
            }

            for (int i = 1; i < model.getListResult().size(); i++) {
                sheet.addCell(new Label(0, 6 + i, model.getListResult().get(i).getWeek() + ""));
                sheet.addCell(new Label(1, 6 + i, model.getListResult().get(i).getDayName()));
                sheet.addCell(new Label(2, 6 + i, model.getListResult().get(i).getHealth() + ""));
                sheet.addCell(new Label(3, 6 + i, model.getListResult().get(i).getImmune() + ""));
                sheet.addCell(new Label(4, 6 + i, model.getListResult().get(i).getDeath() + ""));
                int m = 5;
                for (Entry<String, Integer> e : model.getListResult().get(i).getListStageResult().entrySet()) {
                    sheet.addCell(new Label(m, 6 + i, e.getValue() + ""));
                    m++;
                }
            }
            books.write();
            books.close();

        } catch (IOException | WriteException ex) {
            Logger.getLogger(Excel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
