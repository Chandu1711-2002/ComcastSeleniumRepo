package datadriventesting;

public class GenerateAlphanumericRandomNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=20;
		
		//choose a character random from this string
		String alphanum="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
		
		//create stringbuffer size of alphanumeric string
		StringBuilder sb=new StringBuilder(n);
		for(int i=0;i<=n-1;i++)
		{
			//generate a random no between 0 to alphanum variable length
			int index=(int)(alphanum.length()*Math.random());
			
			//add character one by one in end of sb
			sb.append(alphanum.charAt(index));
		}
		System.out.println(sb);
        
	}

}
