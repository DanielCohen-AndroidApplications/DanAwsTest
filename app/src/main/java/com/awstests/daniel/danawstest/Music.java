package com.awstests.daniel.danawstest;

/**
 * Created by Daniel on 5/20/2016.
 */
import com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper.*;

@DynamoDBTable(tableName = "Music")
public class Music{

    private String Artist;
    private String SongTitle;


    @DynamoDBHashKey(attributeName = "Artist")
    public String getArtist() {
        return Artist;
    }

    public void setArtist(String Artist) {
        this.Artist = Artist;
    }

    @DynamoDBRangeKey(attributeName = "SongTitle")
    public String getSongTitle() {
        return SongTitle;
    }

    public void setSongTitle(String SongTitle) {
        this.SongTitle = SongTitle;
    }


}
