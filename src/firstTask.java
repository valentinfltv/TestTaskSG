import org.ho.yaml.Yaml;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by LuckyMan on 2/15/2016.
 */
public class firstTask {
//Array for randomly generated numbers
        private ArrayList<Integer> numbList;
//Array for values from yml file
        private ArrayList<Integer> ymlList;
//value that won't have duplicates in array
        private int lonelyInt;

// getters and setters for private fields:

        public ArrayList<Integer> getYmlList() {
            return ymlList;
        }
        public void setYmlList(ArrayList<Integer> ymlList) {
            this.ymlList = ymlList;
        }

        public int getLonelyInt() {
            return lonelyInt;
        }
        public void setLonelyInt(int lonelyInt) {
            this.lonelyInt = lonelyInt;
        }

        public ArrayList<Integer> getNumbList() {
            return numbList;
        }
        public void setNumbList(ArrayList<Integer> numbList) {
            this.numbList = numbList;
        }
//end of getters/setters part

//create an array for duplicated numbers and single value without duplicates
        public ArrayList<Integer> createArray() {
            ArrayList<Integer> n = new ArrayList<Integer>();
            for (int i = 0; i < 50; i++) {
                int a = rand();
                if(!n.contains(a)){
                    n.add(a);
                }
            }
            for (int i = 0; i <49 ; i++) {
                n.add(n.get(i));
            }

            System.out.println("create Array done");
            return n;
        }

//return random number in range 0:1000
        public int rand (){
            Random rand=new Random();
            int r=rand.nextInt(1000)+1;
            return r;
        }

//insert numbers to yml file
        public void insertInYml (ArrayList<Integer> ar){
            System.out.println("insertInYml");
            try {
                Yaml.dump(ar, new File("numbers.yml"));
            }catch (IOException e){e.printStackTrace();}
            System.out.println("insertInYml done");
        }

//get data from yml
        public ArrayList<Integer> getData(){
            System.out.println("Get data");
            ArrayList<Integer> list = new ArrayList<Integer>();
            try {
                list = (ArrayList<Integer>)Yaml.load(new File("numbers.yml"));
            }catch (IOException ex){ex.printStackTrace();}
            System.out.println("done get data");
            return list;
        }

//find number without duplicates
        public int findnum(ArrayList<Integer> list){
            System.out.println("find num");
            int num=0;

            for (int i=0; i<list.size();i++) {
                int count = 0;

                for (int j = 0; j < list.size(); j++) {
                    if (list.get(i) == list.get(j)) {
                        count++;
                    }
                }
                if (count==1){num=list.get(i);}
            }
            System.out.println("find num done");
            return num;
        }
//calling key methods for:

        public void start() {
            System.out.println("createYml");
            setNumbList(createArray());
            insertInYml(getNumbList());

            setYmlList(getData());

            System.out.println("Array from Yml file: "+getYmlList());

            setLonelyInt(findnum(getYmlList()));
            System.out.println(getLonelyInt());
        }

}



