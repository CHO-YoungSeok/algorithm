import java.util.*;

class Solution {
    static List<Data> list = new ArrayList<>();
    
    static class Data {
        int code, date, maximum, remain;
        Data(int code, int date, int maximum, int remain) {
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
    
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int extIndex = 0;
        
        switch(ext) {
            case "code" :
                extIndex = 0;
                break;
            case "date" :
                extIndex = 1;
                break;
            case "maximum" :
                extIndex = 2;
                break;
            case "remain" :
                extIndex = 3;
                break;
            default:                
        }
        
        for (int i = 0; i < data.length; i++) {
            if (data[i][extIndex] < val_ext) {
                list.add(new Data(data[i][0], data[i][1],data[i][2], 
                                  data[i][3]));   
            }
        }
                
        int sort_byIndex = 0;
        switch(sort_by) {
            case "code" :
                list.sort((e1, e2) -> e1.code - e2.code);
                break;
            case "date" :
                list.sort((e1, e2) -> e1.date - e2.date);
                break;
            case "maximum" :
                list.sort((e1, e2) -> e1.maximum - e2.maximum);
                break;
            case "remain" :
                list.sort((e1, e2) -> e1.remain - e2.remain);
                break;
            default:                
        }
        int[][] answer = new int[list.size()][4];
        
        for (int i = 0; i < list.size(); i++) {
            answer[i][0] = list.get(i).code;
            answer[i][1] = list.get(i).date;
            answer[i][2] = list.get(i).maximum;
            answer[i][3] = list.get(i).remain;
        }
        
        return answer;
    }
}