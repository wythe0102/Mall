package com.wythe.mall.personal;

/**
 * 我的基因
 * Created by litingchang on 4/16/15.
 */
public class PersonalGene {
    public int geneId;
    public String geneText;
    public String geneDescription;
    public boolean isNew;

    public PersonalGene() {}

    public PersonalGene(int id, String text) {
        geneId = id;
        geneText = text;
    }

    public PersonalGene(int geneId, String geneText, String title ,boolean isNew) {
        this.geneId = geneId;
        this.geneText = geneText;
        this.geneDescription = title;
        this.isNew = isNew;
    }
}
