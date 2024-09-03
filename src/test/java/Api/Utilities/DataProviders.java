package Api.Utilities;

import org.testng.annotations.DataProvider;

public class DataProviders
{

    @DataProvider(name="AllData")
    public String [][] AllDataProvider()
    {

         String fName=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
         int ttlRowCnt=ReadExcelFile.getRowCount(fName,"Sheet1");
         int ttlColCnt=ReadExcelFile.getColCount(fName,"Sheet1");

         String userData[][]=new String[ttlRowCnt][ttlColCnt];

         for(int i=1;i<ttlRowCnt;i++){

             for(int j=0;j<ttlColCnt;j++){
                 userData[i-1][j]=ReadExcelFile.getCellValue(fName,"Sheet1",i,j);
             }
         }
        return userData;
    }

    @DataProvider(name="UserNameData")
    public String [] UserNameDataProvider()
    {

        String fName=System.getProperty("user.dir")+"//TestData//TestData.xlsx";
        int ttlRowCnt=ReadExcelFile.getRowCount(fName,"Sheet1");
        int ttlColCnt=ReadExcelFile.getColCount(fName,"Sheet1");

        String userNameData[]=new String[ttlRowCnt];

        for(int i=1;i<=ttlRowCnt;i++){

            userNameData[i-1]=ReadExcelFile.getCellValue(fName,"Sheet1",ttlRowCnt,1);
        }
        return userNameData;
    }
}
