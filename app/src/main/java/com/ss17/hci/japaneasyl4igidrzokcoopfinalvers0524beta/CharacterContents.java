package com.ss17.hci.japaneasyl4igidrzokcoopfinalvers0524beta;

import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

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

        public String toString() {
            String answer = "";
            for (String meaning:first) {
                answer += meaning + ", ";
            }
            answer = answer.substring(0, answer.length() - 2) + "\n";
            for (String pronounce:second) {
                answer += pronounce + ", ";
            }
            return answer;
        }
    }

    public class LearnSelection {
        private String character;
        private String corrMeaning;
        private String corrPronunciation;
        private ArrayList<String> falseMeanings;
        private ArrayList<String> falsePronunciations;

        public LearnSelection(String c, String cM, String cP, ArrayList<String> fM, ArrayList<String> fP) {
            character = c;
            corrMeaning = cM;
            corrPronunciation = cP;
            falseMeanings = fM;
            falsePronunciations = fP;
        }

        public String getCorrMeaning() {
            return corrMeaning;
        }

        public String getCharacter() {
            return character;
        }

        public String getCorrPronunciation() {
            return corrPronunciation;
        }

        public ArrayList<String> getFalseMeanings() {
            return falseMeanings;
        }

        public ArrayList<String> getFalsePronunciations() {
            return falsePronunciations;
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
        ArrayList<String> mwh = new ArrayList<>();
        mwh.add("what");
        ArrayList<String> pwh = new ArrayList<>();
        pwh.add("nani");
        pwh.add("nan");
        pwh.add("ka");
        Pair wh = new Pair(mwh, pwh);
        basics.put("何", wh);
        //day
        ArrayList<String> mday = new ArrayList<>();
        mday.add("sun");
        mday.add("day");
        mday.add("Japan");
        ArrayList<String> pday = new ArrayList<String>();
        pday.add("hi");
        pday.add("bi");
        pday.add("ka");
        pday.add("nichi");
        pday.add("jitsu");
        Pair day = new Pair(mday, pday);
        basics.put("日", day);
        Log.d("What the actual fuck", day.toString());
        Log.d("fuckkkkk", basics.get("何").toString());
        //month
        ArrayList<String> mm = new ArrayList<>();
        mm.add("month");
        mm.add("moon");
        ArrayList<String> pm = new ArrayList<String>();
        pm.add("tsuki");
        pm.add("getsu");
        pm.add("gatsu");
        Pair m = new Pair(mm, pm);
        basics.put("月", m);
        //fire
        ArrayList<String> mfir = new ArrayList<>();
        mfir.add("fire");
        ArrayList<String> pfir = new ArrayList<String>();
        pfir.add("hi");
        pfir.add("bi");
        pfir.add("ka");
        pfir.add("ho");
        Pair fir = new Pair(mfir, pfir);
        basics.put("火", fir);
        //water
        ArrayList<String> mwat = new ArrayList<>();
        mwat.add("water");
        ArrayList<String> pwat = new ArrayList<String>();
        pwat.add("sui");
        pwat.add("mizu");
        Pair wat = new Pair(mwat, pwat);
        basics.put("水", wat);
        //wood
        ArrayList<String> mwood = new ArrayList<>();
        mwood.add("tree");
        mwood.add("wood");
        ArrayList<String> pwood = new ArrayList<String>();
        pwood.add("ki");
        pwood.add("ko");
        pwood.add("boku");
        pwood.add("moku");
        Pair wood = new Pair(mwood, pwood);
        basics.put("木", wood);
        //small
        ArrayList<String> msmall = new ArrayList<>();
        msmall.add("little");
        msmall.add("small");
        ArrayList<String> psmall = new ArrayList<String>();
        psmall.add("chiisai");
        psmall.add("ko");
        psmall.add("o");
        psmall.add("sa");
        psmall.add("shou");
        Pair small = new Pair(msmall, psmall);
        basics.put("小", small);
        //big
        ArrayList<String> mbig = new ArrayList<>();
        mbig.add("big");
        mbig.add("large");
        mbig.add("very");
        ArrayList<String> pbig = new ArrayList<String>();
        pbig.add("oo");
        pbig.add("ookii");
        pbig.add("dai");
        pbig.add("tai");
        Pair big = new Pair(mbig, pbig);
        basics.put("大", big);
        //right hand side
        ArrayList<String> mright = new ArrayList<>();
        mright.add("right (hand side)");
        ArrayList<String> pright = new ArrayList<String>();
        pright.add("migi");
        pright.add("u");
        pright.add("yuu");
        Pair right = new Pair(mright, pright);
        basics.put("右", right);
        //left
        ArrayList<String> mleft = new ArrayList<>();
        mleft.add("left");
        ArrayList<String> pleft = new ArrayList<String>();
        pleft.add("hidari");
        pleft.add("sa");
        pleft.add("shu");
        pleft.add("tai");Pair left = new Pair(mleft, pleft);
        basics.put("大", left);

        //fill uni
        //talent
        ArrayList<String> mtal = new ArrayList<>();
        mtal.add("ability");
        mtal.add("talent");
        mtal.add("skill");
        mtal.add("capacity");
        ArrayList<String> ptal = new ArrayList<String>();
        ptal.add("yoku");
        ptal.add("noo");
        Pair tal = new Pair(mtal, ptal);
        uni.put("能", tal);
        //exam
        ArrayList<String> mex = new ArrayList<>();
        mex.add("exam");
        mex.add("school");
        mex.add("printing");
        mex.add("proof");
        mex.add("correction");
        ArrayList<String> pex = new ArrayList<String>();
        pex.add("kou");
        pex.add("kyou");
        Pair ex = new Pair(mex, pex);
        uni.put("校", ex);
        //study
        ArrayList<String> mstudy = new ArrayList<>();
        mstudy.add("research");
        mstudy.add("study");
        ArrayList<String> pstudy = new ArrayList<String>();
        pstudy.add("kiwameru");
        pstudy.add("kyuu");
        pstudy.add("ku");
        Pair study = new Pair(mstudy, pstudy);
        uni.put("究", study);
        //learn
        ArrayList<String> mlearn = new ArrayList<>();
        mlearn.add("learn");
        ArrayList<String> plearn = new ArrayList<String>();
        plearn.add("narau");
        plearn.add("narai");
        plearn.add("shuu");
        plearn.add("ju");
        Pair learn = new Pair(mlearn, plearn);
        uni.put("習", learn);
        //book
        ArrayList<String> mbook = new ArrayList<>();
        mbook.add("book");
        mbook.add("present");
        mbook.add("main");
        mbook.add("origin");
        mbook.add("true");
        mbook.add("real");
        ArrayList<String> pbook = new ArrayList<String>();
        pbook.add("moto");
        pbook.add("hon");
        Pair book = new Pair(mbook, pbook);
        uni.put("本", book);
        //wood
        ArrayList<String> mwoods = new ArrayList<>();
        mwoods.add("tree");
        mwoods.add("wood");
        ArrayList<String> pwoods = new ArrayList<String>();
        pwoods.add("ki");
        pwoods.add("ko");
        pwoods.add("boku");
        pwoods.add("moku");
        Pair woods = new Pair(mwoods, pwoods);
        uni.put("木", woods);
        //lecture
        ArrayList<String> mlect = new ArrayList<>();
        mlect.add("lecture");
        mlect.add("club");
        mlect.add("assosiation");
        ArrayList<String> plect = new ArrayList<String>();
        plect.add("kou");
        Pair lect = new Pair(mlect, plect);
        uni.put("講", lect);
        //science
        ArrayList<String> msci = new ArrayList<>();
        msci.add("study");
        msci.add("learning");
        msci.add("science");
        ArrayList<String> psci = new ArrayList<String>();
        psci.add("manabu");
        psci.add("gaku");
        Pair sci = new Pair(msci, psci);
        uni.put("学", sci);
        //degree
        ArrayList<String> mdeg = new ArrayList<>();
        mdeg.add("extent");
        mdeg.add("degree");
        mdeg.add("law");
        mdeg.add("formula");
        mdeg.add("distance");
        mdeg.add("limits");
        mdeg.add("amount");
        ArrayList<String> pdeg = new ArrayList<String>();
        pdeg.add("hodo");
        pdeg.add("tei");
        Pair deg = new Pair(mdeg, pdeg);
        uni.put("程", deg);
        //failure
        ArrayList<String> mfail = new ArrayList<>();
        mfail.add("failure");
        mfail.add("defeat");
        mfail.add("reversal");
        ArrayList<String> pfail = new ArrayList<String>();
        pfail.add("yabureru");
        pfail.add("hai");
        Pair fail = new Pair(mfail, pfail);
        uni.put("敗", fail);

        //fill restaurant
        //food
        ArrayList<String> mfood = new ArrayList<>();
        mfood.add("eat");
        mfood.add("food");
        ArrayList<String> pfood = new ArrayList<String>();
        pfood.add("kuu");
        pfood.add("kurau");
        pfood.add("taberu");
        pfood.add("hamu");
        pfood.add("shouku");
        pfood.add("jiki");
        Pair food = new Pair(mfood, pfood);
        restaurant.put("食", food);
        //taste
        ArrayList<String> mtaste = new ArrayList<>();
        mtaste.add("flavour");
        mtaste.add("taste");
        ArrayList<String> ptaste = new ArrayList<String>();
        ptaste.add("aji");
        ptaste.add("ajiwau");
        ptaste.add("mi");
        Pair taste = new Pair(mtaste, ptaste);
        restaurant.put("味", taste);
        //drink
        ArrayList<String> mdrink = new ArrayList<>();
        mdrink.add("drink");
        mdrink.add("smoke");
        mdrink.add("take");
        ArrayList<String> pdrink = new ArrayList<String>();
        pdrink.add("nomu");
        pdrink.add("nomi");
        pdrink.add("in");
        pdrink.add("on");
        Pair drink = new Pair(mdrink, pdrink);
        restaurant.put("究", drink);
        //buisness
        ArrayList<String> mbuis = new ArrayList<>();
        mbuis.add("utilize");
        mbuis.add("buisness");
        mbuis.add("service");
        mbuis.add("use");
        mbuis.add("employ");
        ArrayList<String> pbuis = new ArrayList<String>();
        pbuis.add("morairu");
        pbuis.add("narai");
        pbuis.add("you");
        Pair buis = new Pair(mbuis, pbuis);
        restaurant.put("用", buis);
        //chopstick
        ArrayList<String> mchop = new ArrayList<>();
        mchop.add("chopsticks");;
        ArrayList<String> pchop = new ArrayList<String>();
        pchop.add("hashi");
        pchop.add("chou");
        pchop.add("chaku");
        Pair chop = new Pair(mchop, pchop);
        restaurant.put("箸", chop);
        //bowl
        ArrayList<String> mbowl = new ArrayList<>();
        mbowl.add("bowl");
        mbowl.add("rice tub");
        mbowl.add("pot");
        mbowl.add("crown");
        ArrayList<String> pvoel = new ArrayList<String>();
        pvoel.add("hachi");
        pvoel.add("hatsu");
        Pair bowl = new Pair(mbowl, pvoel);
        restaurant.put("鉢", bowl);
        //meal
        ArrayList<String> mmeal = new ArrayList<>();
        mmeal.add("meal");
        mmeal.add("boiled rice");
        ArrayList<String> pmeal = new ArrayList<String>();
        pmeal.add("meshi");
        pmeal.add("han");
        Pair meal = new Pair(mmeal, pmeal);
        restaurant.put("飯", meal);
        //aclohol
        ArrayList<String> malc = new ArrayList<>();
        malc.add("sake");
        malc.add("alcohol");
        ArrayList<String> palc = new ArrayList<String>();
        palc.add("sake");
        palc.add("shuu");
        Pair alc = new Pair(malc, palc);
        restaurant.put("酒", alc);
        /*//degree
        ArrayList<String> meanings = new ArrayList<>();
        meanings.add("extent");
        meanings.add("degree");
        meanings.add("law");
        meanings.add("formula");
        meanings.add("distance");
        meanings.add("limits");
        meanings.add("amount");
        ArrayList<String> pronounce = new ArrayList<String>();
        pronounce.add("hodo");
        pronounce.add("tei");
        Pair alc = new Pair(meanings, pronounce);
        restaurant.put("程", alc);
        //failure
        ArrayList<String> meanings = new ArrayList<>();
        meanings.add("failure");
        meanings.add("defeat");
        meanings.add("reversal");
        ArrayList<String> pronounce = new ArrayList<String>();
        pronounce.add("yabureru");
        pronounce.add("hai");
        Pair alc = new Pair(meanings, pronounce);
        restaurant.put("敗", alc);*/

        //fill park
        //grass
        ArrayList<String> mgrass = new ArrayList<>();

        mgrass.add("grass");
        mgrass.add("weeds");
        mgrass.add("herbs");
        mgrass.add("pasture");
        mgrass.add("write");
        mgrass.add("draft");
        ArrayList<String> pgrass = new ArrayList<String>();
        pgrass.add("kusa");
        pgrass.add("sou");
        Pair grass = new Pair(mgrass, pgrass);
        park.put("草", grass);
        //play
        ArrayList<String> mplay = new ArrayList<>();
        mplay.add("play");
        ArrayList<String> pplay = new ArrayList<String>();
        pplay.add("asobu");
        pplay.add("asobasu");
        pplay.add("yuu");
        pplay.add("yu");
        Pair play = new Pair(mplay, pplay);
        park.put("遊", play);
        //sunshine
        ArrayList<String> msun = new ArrayList<>();
        msun.add("sunshine");
        msun.add("yang");
        msun.add("positive");
        msun.add("male");
        msun.add("heaven");
        msun.add("daytime");
        ArrayList<String> psun = new ArrayList<String>();
        psun.add("hi");
        psun.add("you");
        Pair sun = new Pair(msun, psun);
        park.put("陽", sun);
        //laugh
        ArrayList<String> mlau = new ArrayList<>();
        mlau.add("laugh");
        ArrayList<String> plau = new ArrayList<String>();
        plau.add("warau");
        plau.add("emu");
        plau.add("you");
        Pair lau = new Pair(mlau, plau);
        park.put("笑", lau);
        //injury
        ArrayList<String> minju = new ArrayList<>();
        minju.add("harm");
        minju.add("injury");
        ArrayList<String> pinju = new ArrayList<String>();
        pinju.add("gai");
        Pair inju = new Pair(minju, pinju);
        park.put("害", inju);
        //pain
        ArrayList<String> mpain = new ArrayList<>();
        mpain.add("wound");
        mpain.add("hurt");
        mpain.add("injure");
        mpain.add("impair");
        mpain.add("pain");
        mpain.add("injury");
        mpain.add("cut");
        mpain.add("gash");
        mpain.add("scar");
        mpain.add("weak point");
        ArrayList<String> ppain = new ArrayList<String>();
        ppain.add("kizu");
        ppain.add("itamu");
        ppain.add("itameru");
        ppain.add("sou");
        Pair pain = new Pair(mpain, ppain);
        park.put("傷", pain);
        //sport
        ArrayList<String> msport = new ArrayList<>();
        msport.add("frolic");
        msport.add("play");
        msport.add("sport");
        ArrayList<String> psport = new ArrayList<String>();
        psport.add("tawamureru");
        psport.add("zareru");
        psport.add("jareru");
        psport.add("gi");
        psport.add("ge");
        Pair sport = new Pair(msport, psport);
        park.put("戯", sport);
        //park
        ArrayList<String> mpa = new ArrayList<>();
        mpa.add("park");
        mpa.add("garden");
        mpa.add("yard");
        mpa.add("farm");
        ArrayList<String> ppa = new ArrayList<String>();
        ppa.add("sono");
        ppa.add("en");
        Pair pa = new Pair(mpa, ppa);
        park.put("園", pa);
        //walk
        ArrayList<String> mw = new ArrayList<>();
        mw.add("walk");
        ArrayList<String> pw = new ArrayList<String>();
        pw.add("aruku");
        pw.add("ayumu");
        pw.add("ho");
        pw.add("bu");
        pw.add("fu");
        Pair w = new Pair(mw, pw);
        park.put("歩", w);
        //outside
        ArrayList<String> mout = new ArrayList<>();
        mout.add("outside");
        ArrayList<String> pout = new ArrayList<String>();
        pout.add("gai");
        pout.add("to");
        pout.add("hazureru");
        pout.add("hazusu");
        pout.add("hoka");
        pout.add("soto");
        pout.add("ge");
        Pair out = new Pair(mout, pout);
        park.put("外", out);

        Log.d("Testing", basics.toString());
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

    public Pair getMapping(int dictNum, String ch) {
        Log.d("Testing", ch);
        switch(dictNum) {
            case(0):
                Log.d("Testing", basics.get(ch).getFirst().get(0));
                Log.d("Testing", basics.get("大").getFirst().get(0));
                return(basics.get(ch));
            case(1):
                return(park.get(ch));
            case(2):
                return(restaurant.get(ch));
            case(3):
                return(uni.get(ch));
        }
        return null;
    }

    public LearnSelection getRandSet(int packNum) {
        Map<String,Pair> pack;
        switch(packNum) {
            case 1: pack = park; break;
            case 2: pack = restaurant; break;
            case 3: pack = uni; break;
            default:pack = basics;
        }
        Random generator = new Random();
        //Object[] packVals = pack.values().toArray();
        Object[] packChars = pack.keySet().toArray();
        //int[] usedCharNums = new int[5];
        int usedChar = generator.nextInt(packChars.length);
        String mainChar = (String)packChars[usedChar];
        Pair corrects = pack.get(mainChar);
        ArrayList<String> corrM = corrects.getFirst();
        ArrayList<String> corrP = corrects.getSecond();
        String randCorrM = corrM.get(generator.nextInt(corrM.size()));
        String randCorrP = corrP.get(generator.nextInt(corrP.size()));
        ArrayList<String> wrongM = new ArrayList<>();
        ArrayList<String> wrongP = new ArrayList<>();
        int randCharNum = generator.nextInt(packChars.length - 1);
        if(randCharNum == usedChar) {
            randCharNum = packChars.length - 1;
        }
        String randChar = (String)packChars[randCharNum];
        Pair randVal = pack.get(randChar);
        wrongM.add(randVal.getFirst().get(generator.nextInt(randVal.getFirst().size())));
        int randInt = generator.nextInt(randVal.getSecond().size());
        String randPro1 = randVal.getSecond().get(randInt);
        if(randPro1 == randCorrP) {
            try {
                randPro1 = randVal.getSecond().get(randInt + 1);
            } catch (Exception e) {
                try {
                    randPro1 = randVal.getSecond().get(randInt - 1);
                } catch (Exception f) {
                    randPro1 = "baka";
                }
            }
        }
        wrongP.add(randPro1);
        int randCharNum2 = generator.nextInt(packChars.length - 2);
        if(randCharNum2 == usedChar) {
            randCharNum2 = packChars.length - 1;
        }else if(randCharNum2 == randCharNum) {
            randCharNum2 = packChars.length - 2;
        }
        String randChar2 = (String)packChars[randCharNum2];
        Pair randVal2 = pack.get(randChar2);
        wrongM.add(randVal2.getFirst().get(generator.nextInt(randVal2.getFirst().size())));
        int randInt2 = generator.nextInt(randVal2.getSecond().size());
        String randPro2 = randVal2.getSecond().get(randInt2);
        if(randPro2 == randCorrP || randPro2 == randPro1) {
            try {
                randPro2 = randVal2.getSecond().get(randInt + 1);
            } catch (Exception e) {
                try {
                    randPro2 = randVal2.getSecond().get(randInt - 1);
                } catch (Exception f) {
                    randPro2 = "aho";
                }
            }
        }
        wrongP.add(randPro2);
        /*for(int i = 0; i < 4; ++i) {
            int numUnused = packChars.length - (i+1);
            int nextCharNum =  generator.nextInt(numUnused);
            for(int j = 0; j < i+1; ++j) {
                Log.d("Testing RandSet", nextCharNum + ", " + usedCharNums[j]);
                if(nextCharNum == usedCharNums[j]) {
                    nextCharNum = numUnused + j;
                }
            }
            wrongElems.add(pack.get((String)packChars[nextCharNum]));
            usedCharNums[i+1] = nextCharNum;
        }
        ArrayList<String> wrongM1 = wrongElems.get(0).getFirst();
        wrongM.add(wrongM1.get(generator.nextInt(wrongM1.size())));
        ArrayList<String> wrongM2 = wrongElems.get(0).getFirst();
        wrongM.add(wrongM2.get(generator.nextInt(wrongM2.size())));
        ArrayList<String> wrongP1 = wrongElems.get(0).getSecond();
        wrongP.add(wrongP1.get(generator.nextInt(wrongP1.size())));
        ArrayList<String> wrongP2 = wrongElems.get(0).getSecond();
        wrongP.add(wrongP2.get(generator.nextInt(wrongP2.size())));
        Log.d("Testing randSet",wrongM.toString());
        Log.d("Testing randSet",wrongP.toString());*/
        LearnSelection result = new LearnSelection(mainChar, randCorrM, randCorrP, wrongM, wrongP);
        return result;
    }
}
