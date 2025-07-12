public class Strings {
    public static int CountLowerVowels(String str){
        int count=0;
        String vowels = "aeiou";
        for (int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            if (Character.isLowerCase(ch) && vowels.indexOf(ch)!=-1){
                count++;
            }
        }

        return count;
    }

    public static boolean Anagram(String str1,String str2){
        int flag = 0;
        int len1=str1.length();
        int len2=str2.length();
        if (len1==len2){
            if (str1.equals(str2))
            return true;
            for (int i=0;i<len1;i++){
                char ch=str1.charAt(i);
                if(str2.indexOf(ch)==-1){
                    flag=1;
                    break;
                }
            }
            if (flag==1){
                return false;
            }
            else
            return true;
        }
        else {
        return false;
        }
    }

    



    public static void main(String[] args) {
        // System.out.println(CountLowerVowels("Hello My name is Shahnawaz"));
        // System.out.println(Anagram("abzd","cbad"));
        
        

    }
    
}


