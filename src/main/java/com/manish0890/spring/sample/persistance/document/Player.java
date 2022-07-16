package com.manish0890.spring.sample.persistance.document;

import com.manish0890.spring.sample.constants.ElasticsearchIndices;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = ElasticsearchIndices.PLAYERS)
public class Player extends BaseDocument {

    @Field(type = FieldType.Keyword)
    private String playerID;
    @Field(type = FieldType.Integer)
    private Integer birthYear;
    @Field(type = FieldType.Integer)
    private Integer birthMonth;
    @Field(type = FieldType.Text)
    private String birthDay;
    @Field(type = FieldType.Keyword)
    private String birthCountry;
    @Field(type = FieldType.Keyword)
    private String birthCity;
    @Field(type = FieldType.Keyword)
    private String birthState;
    @Field(type = FieldType.Integer)
    private Integer deathYear;
    @Field(type = FieldType.Integer)
    private Integer deathMonth;
    @Field(type = FieldType.Integer)
    private Integer deathDay;
    @Field(type = FieldType.Keyword)
    private String deathCountry;
    @Field(type = FieldType.Keyword)
    private String deathCity;
    @Field(type = FieldType.Keyword)
    private String deathState;
    @Field(type = FieldType.Keyword)
    private String nameFirst;
    @Field(type = FieldType.Keyword)
    private String nameGiven;
    @Field(type = FieldType.Keyword)
    private String nameLast;
    @Field(type = FieldType.Integer)
    private Integer weight;
    @Field(type = FieldType.Integer)
    private Integer height;
    @Field(type = FieldType.Text)
    private String bats;
    @Field(type = FieldType.Text)
    private String throwss;
    @Field(type = FieldType.Text)
    private String debut;
    @Field(type = FieldType.Keyword)
    private String finalGame;
    @Field(type = FieldType.Keyword)
    private String retroID;
    @Field(type = FieldType.Keyword)
    private String bbrefID;

    public String getPlayerID() {
        return playerID;
    }

    public void setPlayerID(String playerID) {
        this.playerID = playerID;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(Integer birthYear) {
        this.birthYear = birthYear;
    }

    public Integer getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(Integer birthMonth) {
        this.birthMonth = birthMonth;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getBirthCountry() {
        return birthCountry;
    }

    public void setBirthCountry(String birthCountry) {
        this.birthCountry = birthCountry;
    }

    public String getBirthCity() {
        return birthCity;
    }

    public void setBirthCity(String birthCity) {
        this.birthCity = birthCity;
    }

    public String getBirthState() {
        return birthState;
    }

    public void setBirthState(String birthState) {
        this.birthState = birthState;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public Integer getDeathMonth() {
        return deathMonth;
    }

    public void setDeathMonth(Integer deathMonth) {
        this.deathMonth = deathMonth;
    }

    public Integer getDeathDay() {
        return deathDay;
    }

    public void setDeathDay(Integer deathDay) {
        this.deathDay = deathDay;
    }

    public String getDeathCountry() {
        return deathCountry;
    }

    public void setDeathCountry(String deathCountry) {
        this.deathCountry = deathCountry;
    }

    public String getDeathCity() {
        return deathCity;
    }

    public void setDeathCity(String deathCity) {
        this.deathCity = deathCity;
    }

    public String getDeathState() {
        return deathState;
    }

    public void setDeathState(String deathState) {
        this.deathState = deathState;
    }

    public String getNameFirst() {
        return nameFirst;
    }

    public void setNameFirst(String nameFirst) {
        this.nameFirst = nameFirst;
    }

    public String getNameGiven() {
        return nameGiven;
    }

    public void setNameGiven(String nameGiven) {
        this.nameGiven = nameGiven;
    }

    public String getNameLast() {
        return nameLast;
    }

    public void setNameLast(String nameLast) {
        this.nameLast = nameLast;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getBats() {
        return bats;
    }

    public void setBats(String bats) {
        this.bats = bats;
    }

    public String getThrowss() {
        return throwss;
    }

    public void setThrowss(String throwss) {
        this.throwss = throwss;
    }

    public String getRetroID() {
        return retroID;
    }

    public void setRetroID(String retroID) {
        this.retroID = retroID;
    }

    public String getBbrefID() {
        return bbrefID;
    }

    public void setBbrefID(String bbrefID) {
        this.bbrefID = bbrefID;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFinalGame() {
        return finalGame;
    }

    public void setFinalGame(String finalGame) {
        this.finalGame = finalGame;
    }
}
