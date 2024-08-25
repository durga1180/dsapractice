package org.example.contest;

import java.util.Arrays;
import java.util.List;

public class PangramCheck {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("the", "quick", "brown", "fox","jumps","over","the","lazy","dog");
        StringBuilder stringBuilder = new StringBuilder();
        list.forEach(stringBuilder::append);
        System.out.println(stringBuilder);
        char[] array = stringBuilder.toString().toCharArray();
        Arrays.sort(array);
        String string = new String(array);
        System.out.println(string);
    }
}
