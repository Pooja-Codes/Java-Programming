public class Encoder {
	public static String encodeNumeric(String s)throws NumberFormatException  {
		//Assignment Description: 
		//assume it takes lower case letter input. But spaces should be encoded as spaces.
		String output="";
		if (s.indexOf('.')==-1){//if string not contain . means encode! 
			//ex,input: pooja patel then output: 16.15.15.10.1. 16.1.20.5.12.
			for(int i=0;i<s.length();i++) {
				char c=s.charAt(i);
				if(c>='a' && c<='z') {
					output+=(c-'a'+1);
					output+='.';
				}
				else if(c==32) {//handling spaces
					output+=" ";
				}
			}
		}
		else {//if string contain . means decode!
			//ex,input: 16.15.15.10.1. 16.1.20.5.12. then output: pooja patel
			s=s.replace(" ","27.");
			//System.out.println(s);//debug
			String []temp=s.split("\\.");
			//System.out.println(Arrays.toString(temp)); //debug
			for(int i=0;i<temp.length;i++) {
				if (Integer.parseInt(temp[i])==27) {
					output+=" ";
				}
				else {
					output+=(char)(Integer.parseInt(temp[i])+96);
				}
			}
		}
		return output;
	}

	public static String encodeROT13(String s) {
		//Assignment Description: 
		//assume it takes lower case letter input. But spaces should be encoded as spaces.
		String output="";
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='a' && c<='m') {
				c+=13;
			}
			else if(c>='n' && c<='z') {
				c-=13;
			}
			//other chars as it is so spaces will be also handled there.decode and encode also!
			output+=c;
		}
		return output;
		//ex, input: pooja  then output: cbbwn
		//ex, input: cbbwn  then output: pooja
	}
}
