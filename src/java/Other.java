import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created with IDEA
 * Author: LuoHengYi
 * Date: 2019/11/5
 * Time: 2:35 下午
 */
public class Other {
    public static void main(String[] args) throws Exception {
        ArrayList<String> ips = new ArrayList<>();
        FileInputStream inputStream = new FileInputStream("/Users/luohengyi/java/IdeaProjects/imooc/dataStructure/附件1-国网四川信通公司2019年业务平台中间件运维清单.xls");

        HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
        // 获取想要读取的sheet
        HSSFSheet sheet = workbook.getSheetAt(0);
        // 循环取得所有的行
        // 使用excel必须提供用户模板
        for(int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
            // row代表每一行
            HSSFRow row = sheet.getRow(rowIndex);

            // 获取单元单cell中的数据
            String ip = row.getCell(4).getStringCellValue();
            ips.add(ip);
        }

        float Max = 70, Min = 45.0f;
        for (int i = 0; i < 19; i++) {
            BigDecimal db = new BigDecimal(Math.random() * (Max - Min) + Min);
            String cpu = db.setScale(2, BigDecimal.ROUND_HALF_UP)// 保留30位小数并四舍五入
                    .toString();
            BigDecimal ipb = new BigDecimal(Math.random() * (60 - 1) + 1);
            String ipbs = ipb.setScale(0, BigDecimal.ROUND_HALF_UP)// 保留30位小数并四舍五入
                    .toString();
            System.out.println("本日cpu使用率最高 "+ips.get(Integer.parseInt(ipbs))+"使用率"+cpu);
        }
    }
}
