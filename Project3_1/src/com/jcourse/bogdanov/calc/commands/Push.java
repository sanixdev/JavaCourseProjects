package com.jcourse.bogdanov.calc.commands;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Push extends CommandExec {
    public void exec(String inCommand, LinkedList<Double> inStack, HashMap<String, Double> inMap){
        StringTokenizer st = Parser.getTokenizer(inCommand);
        int count = st.countTokens();
        if (count == 2 ){
            st.nextToken();
            String paramOrNumber = st.nextToken();
            try {
                Double number = Double.parseDouble(paramOrNumber);
                inStack.addLast(number);
            }catch (NumberFormatException e){
                if (inMap.containsKey(paramOrNumber)){
                    inStack.addLast(inMap.get(paramOrNumber));
                }
            }
        }
    }
}