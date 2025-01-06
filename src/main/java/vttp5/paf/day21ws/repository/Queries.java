package vttp5.paf.day21ws.repository;

public class Queries {
    public static String SQL_SELECT_BOOKS = """
            select * from kindle where author like CONCAT('%', ?, '%') limit ?
            """;

    public static String SQL_SELECT_ASIN = """
            select * from kindle where asin = ?
            """;
}
