package m1_practice;
import java.util.*;

class Version {
    String version;
    int size;
    int order;

    Version(String version, int size, int order) {
        this.version = version;
        this.size = size;
        this.order = order;
    }
}
public class VersionControlSystem {
	
	Map<String, List<Version>> storage = new HashMap<>();
    int uploadCounter = 0;
    
    public void upload(String fileName, String version, int fileSize) {
    	
    	storage.putIfAbsent(fileName,new ArrayList<>());
    	
    	for(Version v: storage.get(fileName)) {
    		if(v.version.equals(version)) {
    			return ;
    		}
    		
    	}
    	
    	storage.get(fileName).add(new Version(version,fileSize,uploadCounter++));
    }
    
    public void fetch(String fileName) {
    	if(!storage.containsKey(fileName) || storage.get(fileName).isEmpty()) {
    		System.out.println("File Not Found");
    		return ;
    	}
    	List<Version> l=new ArrayList<>(storage.get(fileName));
    	Collections.sort(l,(a,b)->{
    			if(a.size!=b.size) {
    				return a.size-b.size;
    			}
    			
    			return a.version.compareTo(b.version);
    	});
    	 for(Version v : l) {
             System.out.println(fileName + " " + v.version + " " + v.size);
         }
    }
    
    public void latest(String fileName) {
        if(!storage.containsKey(fileName) || storage.get(fileName).isEmpty()) {
            System.out.println("File Not Found");
            return;
        }
        Version latest=storage.get(fileName).get(0);
        for(Version v:storage.get(fileName)) {	
        	if(v.order>latest.order) {
        		latest=v;
        	}
        }
        System.out.println(fileName + " " + latest.version + " " + latest.size);
    }
    
    public void totalStorage(String fileName) {
        if(!storage.containsKey(fileName) || storage.get(fileName).isEmpty()) {
            System.out.println("File Not Found");
            return;
        }
        int sum = 0;
        for(Version v : storage.get(fileName)) {
            sum += v.size;
        }
        System.out.println(fileName + " " + sum);
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        VersionControlSystem vcs = new VersionControlSystem();
        for(int i = 0; i < n; i++) {
            String[] input = sc.nextLine().split("\\s+");
            String command = input[0];
            if(command.equals("UPLOAD")) {
                String fileName = input[1];
                String version = input[2];
                int size = Integer.parseInt(input[3]);
                vcs.upload(fileName, version, size);
            }else if(command.equals("FETCH")) {
                vcs.fetch(input[1]);
            }else if(command.equals("LATEST")) {
                vcs.latest(input[1]);
            }else if(command.equals("TOTAL_STORAGE")) {
                vcs.totalStorage(input[1]);
            }
        }
        sc.close();
    }
}