import java.util.*;

public class WordLadder {
    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();

    int nodeNum = 0;
    public int ladderLength(String beginWord, String endWord, List<String> wordList){
        for (String word:wordList) {
            addEdge(word);
        }
        if(!wordId.containsKey(endWord)) return 0;
        addEdge(beginWord);
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[endId] = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(beginId);
        while(!queue.isEmpty()){
            int curId = queue.poll();
            if(curId == endId){
                return dis[endId] / 2 + 1;
            }
            for(int newId : edge.get(curId)){
                if(dis[newId] == Integer.MAX_VALUE) {
                    dis[newId] = dis[curId] + 1;
                    queue.offer(newId);
                }
            }
        }


        return 0;
    }

    public void addEdge(String word){
        addWord(word);
        int id1 = wordId.get(word);
        char[] arr = word.toCharArray();
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            char temp = arr[i];
            arr[i] = '*';
            String newWord = new String(arr);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            arr[i] = temp;
        }
    }

    private void addWord(String word) {
        if(!wordId.containsKey(word)){
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }
}
