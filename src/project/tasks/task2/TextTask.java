package project.tasks.task2;


import project.tasks.Content;

import java.util.*;
import java.util.Map.Entry;

public class TextTask extends Content {

    private String punctuation = "[-!?\"\'(),.:;]";

    private Map<String,Integer> wordsStatisticMap;

    public TextTask() { }

    public TextTask(String filePath) {
        super(filePath);
        this.getNonAlphabetMap();
        this.getAlphabetMap();
    }

    private List<String> paragrahProcessing(String str)
    {
        String[] arr = str.split(" ");
        List<String> wordList = new ArrayList<>();

        int
                hyphenCounter = 0,
                hyphenIndex = 0,
                noAlphabeticCounter = 0;

        for (String line : arr) {

            hyphenCounter = 0;
            hyphenIndex = 0;
            for(int i = 0; i < line.length(); i++)
            {
                if(line.charAt(i) == '-')
                {
                    hyphenCounter++;
                    hyphenIndex = i;
                }
            }

            line = line.replaceAll(punctuation, "");
            line = line.toLowerCase();

            noAlphabeticCounter = 0;
            for (int i = 0; i < line.length(); i++)
            {
                if (!Character.isAlphabetic(line.charAt(i)))
                { noAlphabeticCounter++; }
            }

            if(line.length() > 0 && hyphenCounter == 1)
            {
                StringBuffer strBuff = new StringBuffer(line);
                strBuff.insert(hyphenIndex, '-');
                line = strBuff.toString();
            }
            
            if (noAlphabeticCounter == 0 && line.length() > 0)
            { wordList.add(line); }
        }

        return wordList;
    }

    private void getNonAlphabetMap()
    {
        this.wordsStatisticMap = new LinkedHashMap<>();

        for (String line: this.contentList)
        {
            for (String word : this.paragrahProcessing(line)) {

                if(this.wordsStatisticMap.containsKey(word))
                { this.wordsStatisticMap.put(word, this.wordsStatisticMap.get(word) + 1); }
                else
                { this.wordsStatisticMap.put(word,1); }
            }
        }
    }

    private void getAlphabetMap()
    {
        List<Integer> frequencyList = new ArrayList<>(this.wordsStatisticMap.values());
        Collections.sort(frequencyList);
        Collections.reverse(frequencyList);
        Set<Integer> frequencySet = new LinkedHashSet<>(frequencyList);
        frequencyList.clear();
        frequencyList.addAll(frequencySet);

        Map<String, Integer>
                buffMap = new TreeMap<>(),
                outputMap = new LinkedHashMap<>();

        for (Integer frequency: frequencyList)
        {
            buffMap.clear();
            for (Entry<String, Integer> pair : this.wordsStatisticMap.entrySet()) {
                if (pair.getValue() == frequency)
                { buffMap.put(pair.getKey(), pair.getValue()); }
            }
            outputMap.putAll(buffMap);
        }

        this.wordsStatisticMap = outputMap;
    }

    public void showWordStatistic()
    {
        for (Entry<String , Integer> pair : this.wordsStatisticMap.entrySet())
        { System.out.println(pair.getKey() + " - " + pair.getValue()); }
    }

}

