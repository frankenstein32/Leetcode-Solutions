import java.util.*;

public class SubarraySumDivbyK{
	

	public String[] findOccurences(String text, String first, String second){


		StringBuilder sb = new StringBuilder("");
		String[] tokens = text.split(" ");

		for(int i = 2;i < tokens.length();i++){

			if(tokens[i - 2].equals(first) && tokens[i -1].equals(second)){

				if(!"".equals(sb.toString())){
					sb.append(" ");
				}

				sb.append(tokens[i]);
			}
		}

		if("".equals(sb)){
			return new String[0];
		}

		String[] arr = sb.toString.split(" ");

		return arr;
	}

}