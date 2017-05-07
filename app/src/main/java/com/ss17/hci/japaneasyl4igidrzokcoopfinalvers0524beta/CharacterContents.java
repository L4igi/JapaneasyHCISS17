package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Rosa on 06.05.2017.
 */

class CharacterContents {
    //probs to stackoverflow http://stackoverflow.com/questions/6044923/generic-pair-class
    public class Pair {
        private ArrayList<String> first; //first member of pair
        private ArrayList<String> second; //second member of pair

        public Pair(ArrayList<String> first, ArrayList<String> second) {
            this.first = first;
            this.second = second;
        }

        public void reassign(ArrayList<String> f, ArrayList<String> s){
            first = f;
            second = s;
        }

        public ArrayList<String> getFirst() {
            return first;
        }

        public ArrayList<String> getSecond() {
            return second;
        }
    }
    // end probs to stackoverflow

    //kanji -- meanings - pronounciations
    Map<String, Pair> basics = new HashMap<>();
    Map<String, Pair> uni = new HashMap<>();
    Map<String, Pair> restaurant = new HashMap<>();
    Map<String, Pair> park = new HashMap<>();

    CharacterContents() {
        //fill basics
        //what
        ArrayList<String> meanings = new ArrayList<>();
        meanings.add("what");
        ArrayList<String> pronounce = new ArrayList<>();
        pronounce.add("nani");
        pronounce.add("nan");
        pronounce.add("ka");
        Pair toAdd = new Pair(meanings, pronounce);
        basics.put("何", toAdd);
        //day
        meanings.clear();
        meanings.add("sun");
        meanings.add("day");
        meanings.add("Japan");
        pronounce.clear();
        pronounce.add("hi");
        pronounce.add("bi");
        pronounce.add("ka");
        pronounce.add("nichi");
        pronounce.add("jitsu");
        toAdd.reassign(meanings, pronounce);
        basics.put("日", toAdd);
        //month
        meanings.clear();
        meanings.add("month");
        meanings.add("moon");
        pronounce.clear();
        pronounce.add("tsuki");
        pronounce.add("getsu");
        pronounce.add("gatsu");
        toAdd.reassign(meanings, pronounce);
        basics.put("月", toAdd);
        //fire
        meanings.clear();
        meanings.add("fire");
        pronounce.clear();
        pronounce.add("hi");
        pronounce.add("bi");
        pronounce.add("ka");
        pronounce.add("ho");
        toAdd.reassign(meanings, pronounce);
        basics.put("火", toAdd);
        //water
        meanings.clear();
        meanings.add("water");
        pronounce.clear();
        pronounce.add("sui");
        pronounce.add("mizu");
        toAdd.reassign(meanings, pronounce);
        basics.put("水", toAdd);
        //wood
        meanings.clear();
        meanings.add("tree");
        meanings.add("wood");
        pronounce.clear();
        pronounce.add("ki");
        pronounce.add("ko");
        pronounce.add("boku");
        pronounce.add("moku");
        toAdd.reassign(meanings, pronounce);
        basics.put("木", toAdd);
        //small
        meanings.clear();
        meanings.add("little");
        meanings.add("small");
        pronounce.clear();
        pronounce.add("chiisai");
        pronounce.add("ko");
        pronounce.add("o");
        pronounce.add("sa");
        pronounce.add("shou");
        toAdd.reassign(meanings, pronounce);
        basics.put("小", toAdd);
        //big
        meanings.clear();
        meanings.add("big");
        meanings.add("large");
        meanings.add("very");
        pronounce.clear();
        pronounce.add("oo");
        pronounce.add("ookii");
        pronounce.add("dai");
        pronounce.add("tai");toAdd.reassign(meanings, pronounce);
        basics.put("大", toAdd);
        //right hand side
        meanings.clear();
        meanings.add("right (hand side)");
        pronounce.clear();
        pronounce.add("migi");
        pronounce.add("u");
        pronounce.add("yuu");
        toAdd.reassign(meanings, pronounce);
        basics.put("右", toAdd);
        //left
        meanings.clear();
        meanings.add("left");
        pronounce.clear();
        pronounce.add("hidari");
        pronounce.add("sa");
        pronounce.add("shu");
        pronounce.add("tai");toAdd.reassign(meanings, pronounce);
        basics.put("大", toAdd);

        //fill uni
        //talent
        meanings.clear();
        meanings.add("ability");
        meanings.add("talent");
        meanings.add("skill");
        meanings.add("capacity");
        pronounce.clear();
        pronounce.add("yoku");
        pronounce.add("noo");
        toAdd.reassign(meanings, pronounce);
        uni.put("能", toAdd);
        //exam
        meanings.clear();
        meanings.add("exam");
        meanings.add("school");
        meanings.add("printing");
        meanings.add("proof");
        meanings.add("correction");
        pronounce.clear();
        pronounce.add("kou");
        pronounce.add("kyou");
        toAdd.reassign(meanings, pronounce);
        uni.put("校", toAdd);
        //study
        meanings.clear();
        meanings.add("research");
        meanings.add("study");
        pronounce.clear();
        pronounce.add("kiwameru");
        pronounce.add("kyuu");
        pronounce.add("ku");
        toAdd.reassign(meanings, pronounce);
        uni.put("究", toAdd);
        //learn
        meanings.clear();
        meanings.add("learn");
        pronounce.clear();
        pronounce.add("narau");
        pronounce.add("narai");
        pronounce.add("shuu");
        pronounce.add("ju");
        toAdd.reassign(meanings, pronounce);
        uni.put("習", toAdd);
        //book
        meanings.clear();
        meanings.add("book");
        meanings.add("present");
        meanings.add("main");
        meanings.add("origin");
        meanings.add("true");
        meanings.add("real");
        pronounce.clear();
        pronounce.add("moto");
        pronounce.add("hon");
        toAdd.reassign(meanings, pronounce);
        uni.put("本", toAdd);
        //wood
        meanings.clear();
        meanings.add("tree");
        meanings.add("wood");
        pronounce.clear();
        pronounce.add("ki");
        pronounce.add("ko");
        pronounce.add("boku");
        pronounce.add("moku");
        toAdd.reassign(meanings, pronounce);
        uni.put("木", toAdd);
        //lecture
        meanings.clear();
        meanings.add("lecture");
        meanings.add("club");
        meanings.add("assosiation");
        pronounce.clear();
        pronounce.add("kou");
        toAdd.reassign(meanings, pronounce);
        uni.put("講", toAdd);
        //science
        meanings.clear();
        meanings.add("study");
        meanings.add("learning");
        meanings.add("science");
        pronounce.clear();
        pronounce.add("manabu");
        pronounce.add("gaku");
        toAdd.reassign(meanings, pronounce);
        uni.put("学", toAdd);
        //degree
        meanings.clear();
        meanings.add("extent");
        meanings.add("degree");
        meanings.add("law");
        meanings.add("formula");
        meanings.add("distance");
        meanings.add("limits");
        meanings.add("amount");
        pronounce.clear();
        pronounce.add("hodo");
        pronounce.add("tei");
        toAdd.reassign(meanings, pronounce);
        uni.put("程", toAdd);
        //failure
        meanings.clear();
        meanings.add("failure");
        meanings.add("defeat");
        meanings.add("reversal");
        pronounce.clear();
        pronounce.add("yabureru");
        pronounce.add("hai");
        toAdd.reassign(meanings, pronounce);
        uni.put("敗", toAdd);

        //fill restaurant
        //food
        meanings.clear();
        meanings.add("eat");
        meanings.add("food");
        pronounce.clear();
        pronounce.add("kuu");
        pronounce.add("kurau");
        pronounce.add("taberu");
        pronounce.add("hamu");
        pronounce.add("shouku");
        pronounce.add("jiki");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("食", toAdd);
        //taste
        meanings.clear();
        meanings.add("flavour");
        meanings.add("taste");
        pronounce.clear();
        pronounce.add("aji");
        pronounce.add("ajiwau");
        pronounce.add("mi");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("味", toAdd);
        //drink
        meanings.clear();
        meanings.add("drink");
        meanings.add("smoke");
        meanings.add("take");
        pronounce.clear();
        pronounce.add("nomu");
        pronounce.add("nomi");
        pronounce.add("in");
        pronounce.add("on");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("究", toAdd);
        //buisness
        meanings.clear();
        meanings.add("utilize");
        meanings.add("buisness");
        meanings.add("service");
        meanings.add("use");
        meanings.add("employ");
        pronounce.clear();
        pronounce.add("morairu");
        pronounce.add("narai");
        pronounce.add("you");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("用", toAdd);
        //chopstick
        meanings.clear();
        meanings.add("chopsticks");;
        pronounce.clear();
        pronounce.add("hashi");
        pronounce.add("chou");
        pronounce.add("chaku");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("箸", toAdd);
        //bowl
        meanings.clear();
        meanings.add("bowl");
        meanings.add("rice tub");
        meanings.add("pot");
        meanings.add("crown");
        pronounce.clear();
        pronounce.add("hachi");
        pronounce.add("hatsu");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("鉢", toAdd);
        //meal
        meanings.clear();
        meanings.add("meal");
        meanings.add("boiled rice");
        pronounce.clear();
        pronounce.add("meshi");
        pronounce.add("han");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("飯", toAdd);
        //aclohol
        meanings.clear();
        meanings.add("sake");
        meanings.add("alcohol");
        pronounce.clear();
        pronounce.add("sake");
        pronounce.add("shuu");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("酒", toAdd);
        /*//degree
        meanings.clear();
        meanings.add("extent");
        meanings.add("degree");
        meanings.add("law");
        meanings.add("formula");
        meanings.add("distance");
        meanings.add("limits");
        meanings.add("amount");
        pronounce.clear();
        pronounce.add("hodo");
        pronounce.add("tei");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("程", toAdd);
        //failure
        meanings.clear();
        meanings.add("failure");
        meanings.add("defeat");
        meanings.add("reversal");
        pronounce.clear();
        pronounce.add("yabureru");
        pronounce.add("hai");
        toAdd.reassign(meanings, pronounce);
        restaurant.put("敗", toAdd);*/

        //fill park
        //grass
        meanings.clear();
        meanings.add("grass");
        meanings.add("weeds");
        meanings.add("herbs");
        meanings.add("pasture");
        meanings.add("write");
        meanings.add("draft");
        pronounce.clear();
        pronounce.add("kusa");
        pronounce.add("sou");
        toAdd.reassign(meanings, pronounce);
        park.put("草", toAdd);
        //play
        meanings.clear();
        meanings.add("play");
        pronounce.clear();
        meanings.add("asobu");
        meanings.add("asobasu");
        meanings.add("yuu");
        pronounce.add("yu");
        toAdd.reassign(meanings, pronounce);
        park.put("遊", toAdd);
        //sunshine
        meanings.clear();
        meanings.add("sunshine");
        meanings.add("yang");
        meanings.add("positive");
        meanings.add("male");
        meanings.add("heaven");
        meanings.add("daytime");
        pronounce.clear();
        pronounce.add("hi");
        pronounce.add("you");
        toAdd.reassign(meanings, pronounce);
        park.put("陽", toAdd);
        //laugh
        meanings.clear();
        meanings.add("laugh");
        pronounce.clear();
        pronounce.add("warau");
        pronounce.add("emu");
        pronounce.add("you");
        toAdd.reassign(meanings, pronounce);
        park.put("笑", toAdd);
        //injury
        meanings.clear();
        meanings.add("harm");
        meanings.add("injury");
        pronounce.clear();
        pronounce.add("gai");
        toAdd.reassign(meanings, pronounce);
        park.put("害", toAdd);
        //pain
        meanings.clear();
        meanings.add("wound");
        meanings.add("hurt");
        meanings.add("injure");
        meanings.add("impair");
        meanings.add("pain");
        meanings.add("injury");
        meanings.add("cut");
        meanings.add("gash");
        meanings.add("scar");
        meanings.add("weak point");
        pronounce.clear();
        pronounce.add("kizu");
        pronounce.add("itamu");
        pronounce.add("itameru");
        pronounce.add("sou");
        toAdd.reassign(meanings, pronounce);
        park.put("傷", toAdd);
        //sport
        meanings.clear();
        meanings.add("frolic");
        meanings.add("play");
        meanings.add("sport");
        pronounce.clear();
        pronounce.add("tawamureru");
        pronounce.add("zareru");
        pronounce.add("jareru");
        pronounce.add("gi");
        pronounce.add("ge");
        toAdd.reassign(meanings, pronounce);
        park.put("戯", toAdd);
        //park
        meanings.clear();
        meanings.add("park");
        meanings.add("garden");
        meanings.add("yard");
        meanings.add("farm");
        pronounce.clear();
        pronounce.add("sono");
        pronounce.add("en");
        toAdd.reassign(meanings, pronounce);
        park.put("園", toAdd);
        //walk
        meanings.clear();
        meanings.add("walk");
        pronounce.clear();
        pronounce.add("aruku");
        pronounce.add("ayumu");
        pronounce.add("ho");
        pronounce.add("bu");
        pronounce.add("fu");
        toAdd.reassign(meanings, pronounce);
        park.put("歩", toAdd);
        //outside
        meanings.clear();
        meanings.add("outside");
        pronounce.clear();
        pronounce.add("gai");
        pronounce.add("to");
        pronounce.add("hazureru");
        pronounce.add("hazusu");
        pronounce.add("hoka");
        pronounce.add("soto");
        pronounce.add("ge");
        toAdd.reassign(meanings, pronounce);
        park.put("外", toAdd);
    }

    public String[] getParkChars() {
        ArrayList<String> parky = new ArrayList<>();
        for (String chars: park.keySet()) {
            parky.add(chars);
        }
        return parky.toArray(new String[0]);
    }

    public String[] getUniChars() {
        ArrayList<String> uniy = new ArrayList<>();
        for (String chars: uni.keySet()) {
            uniy.add(chars);
        }
        return uniy.toArray(new String[0]);
    }

    public String[] getResChars() {
        ArrayList<String> resy = new ArrayList<>();
        for (String chars: restaurant.keySet()) {
            resy.add(chars);
        }
        return resy.toArray(new String[0]);
    }

    public String[] getBaseChars() {
        ArrayList<String> basey = new ArrayList<>();
        for (String chars: basics.keySet()) {
            basey.add(chars);
        }
        return basey.toArray(new String[0]);
    }

}
