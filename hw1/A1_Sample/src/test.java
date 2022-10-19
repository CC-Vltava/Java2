import java.io.FileNotFoundException;
import java.util.*;
import java.io.File;


public class test {
	
	public List<List<String>> datas = new ArrayList<>();
	
	public List<String> splitLine(String line){
		List<String> ans = new ArrayList<>();
		int flag = 0;
		StringBuilder s = new StringBuilder();
		for(int i = 0; i < line.length(); i++)
		{
			char c = line.charAt(i);
			if(c == ',' && flag == 0){
				ans.add(s.toString());
				s = new StringBuilder();
			}
			else{
				s.append(c);
				if(c == '"')
					flag ^= 1;
			}
		}
//		System.out.println(ans.toArray().length);
		return ans;
	}
	
	public test(String dataset_path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(dataset_path));
//		int flag = 0;
		scanner.nextLine();
		while (scanner.hasNext()) {
			List<String> data = splitLine(scanner.nextLine());
			this.datas.add(data);
		}
		scanner.close();
	}
	
	public Map<Integer, Integer> getMovieCountByYear(){
		Map<Integer, Integer> ans = new HashMap<>();
		for(List<String> item : this.datas){
			String year = item.get(2);
			if(year.equals(""))
				continue;
			Integer ce = Integer.parseInt(year);
			ans.replace(ce, ans.get(ce), ans.get(ce) + 1);
		}
		return ans;
	}
	
	public Map<String, Integer> getMovieCountByGenre() {
		Map<String, Integer> ans = new HashMap<>();
		for(List<String> item : this.datas){
			String genre = item.get(5);
			if(genre.equals(""))
				continue;
			if(ans.containsKey(genre))
				ans.replace(genre, ans.get(genre), ans.get(genre) + 1);
			else
				ans.put(genre, 1);
		}
		ans.entrySet().stream().sorted(
				(a, b) ->
						(a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) :
								Integer.compare(a.getValue(), b.getValue())));
		return ans;
	}
	
	
	
	public static void main(String[] args) throws Exception {
		MovieAnalyzer movieAnalyzer = new MovieAnalyzer("resources/imdb_top_500.csv");
//		System.out.println(movieAnalyzer.datas.get(0).toString());
//		System.out.println(movieAnalyzer.datas.get(1).toString());
//		System.out.println(movieAnalyzer.datas.get(2).toString());
//		System.out.println(movieAnalyzer.getMovieCountByGenre().toString());
		
		
	}
	
	
	
}

