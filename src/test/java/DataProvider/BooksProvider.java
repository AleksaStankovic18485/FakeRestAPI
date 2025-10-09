package DataProvider;

import DataModels.BooksRequest;
import com.github.javafaker.Faker;
import common.ValueChoosers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class BooksProvider {

    public static BooksRequest prepareBooksRequest() {
        BooksRequest booksRequest = new BooksRequest();
        booksRequest.setId(Faker.instance().random().nextInt(105));
        booksRequest.setTitle(ValueChoosers.getRandomTitle());
        booksRequest.setDescription(Faker.instance().lorem().sentence());
        booksRequest.setPageCount(Faker.instance().number().numberBetween(60, 100));
        booksRequest.setExcerpt(Faker.instance().leagueOfLegends().quote());

        SimpleDateFormat isoFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        isoFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date randomDate = Faker.instance().date().birthday();
        String formattedDate = isoFormat.format(randomDate);

        booksRequest.setPublishDate(formattedDate);

        return  booksRequest;

    }
}
