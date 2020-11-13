package com.aux.terminator.tool;



public class DataTransfer {   //
    public String[] PickItemsWith(char flag,String data){  //多选数据集以固定符号分开该方法可以提取出元素，返回数组。
        String Flag = ""+flag;
        String items = data+' '; //结束标志是空格
        char items_CharArray[] = items.toCharArray();
        String [] item_Array =new String[10];//投票项最大容量
        int num = 0;
        String start ="";
        for(int i = 0;i<items_CharArray.length;i++){
            start=start+items_CharArray[i];
            if(items_CharArray[i]==flag||items_CharArray[i]==' '){
                item_Array[num] = start.replace(Flag,"").trim(); //将选项去掉，和空格。
                start = "";
                num++;
            }
        }
        return item_Array;
    }

}
