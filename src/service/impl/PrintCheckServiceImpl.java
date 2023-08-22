package service.impl;

import model.Check;
import model.Position;
import service.PrintCheckService;
import util.ParsingFile;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintCheckServiceImpl implements PrintCheckService {
    private final ParsingFile parsingFile = new ParsingFile();
    private static final String CASH_RECEIPT = "CASH RECEIPT";
    private static final String SUPERMARKET = "SUPERMARKET №";
    private static final String TEL = "Tel:";
    private static final String CASHIER = "cashier: №";
    private static final String DATE = "DATE:";
    private static final String TIME = "TIME:";
    private static final String QTY = "QTY";
    private static final String DESCRIPTION = "DESCRIPTION";
    private static final String PRICE = "PRICE";
    private static final String TOTAL = "TOTAL";
    private static final String DISCOUNT_CARD = "DISCOUNT CARD -%d%%            -%d";
    private static final String DISCOUNT_10 = "discount 10%: -";
    private static final String DIVIDER = "----------------------------------";
    private static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("MM-dd-yy");

    @Override
    public List<String> prepareCheck(Check check) {
        List<String> list = new ArrayList<>();
        String timeFormat = TIME_FORMATTER.format(check.getDateTime());
        String dateFormat = DATE_FORMATTER.format(check.getDateTime());
        String cashReceiptFormat = String.format("%25s", CASH_RECEIPT);
        String supermarketFormat = String.format("%22s %5s", SUPERMARKET, check.getSupermarketNumber());
        String addressFormat = String.format("%32s", check.getAddress());
        String phoneFormat = String.format("%14s %12s", TEL, check.getPhoneNumber());
        String cashierFormat = String.format("%10s %4s", CASHIER, check.getCashierNumber());
        String dateTimeFormat = String.format("%25s %8s %n %24s %8s", DATE, dateFormat, TIME, timeFormat);
        String columnNamesFormat = String.format("%-4s %-15s %6s %6s", QTY, DESCRIPTION, PRICE, TOTAL);
        String priceFormat = String.format("%-22s %11d", PRICE, check.getBasket().getPrice());
        String totalPriceFormat = String.format("%-22s %11d", TOTAL, check.getBasket().getTotalPrice());

        Collections.addAll(list, cashReceiptFormat, supermarketFormat, addressFormat, phoneFormat, cashierFormat,
                dateTimeFormat, DIVIDER, columnNamesFormat);

        for (Position position : check.getBasket().getPositions()) {
            list.add(String.format("%-4d %-15s %6d %6d",
                    position.getQuantity(), position.getProduct().getName(),
                    position.getProduct().getPrice(), position.getPriceByPosition()));
            if (position.getDiscountByPosition() != 0) {
                list.add(String.format("%29s %d ", DISCOUNT_10, position.getDiscountByPosition()));
            }
        }
        if (check.getBasket().getOrder().getDiscountCard() != null) {
            String discountCardFormat = String.format(DISCOUNT_CARD, check.getBasket().getOrder().getDiscountCard()
                            .getPercent(), check.getBasket().getDiscountByCard());
            Collections.addAll(list, DIVIDER, DIVIDER, priceFormat, discountCardFormat, totalPriceFormat);
        } else {
            Collections.addAll(list, DIVIDER, DIVIDER, totalPriceFormat);
        }
        return list;
    }

    @Override
    public void printCheckToConsole(Check check) {
        for (String str : prepareCheck(check)) {
            System.out.println(str);
        }
    }

    @Override
    public void exportCheckToFile(Check check) {
        parsingFile.writeAll(parsingFile.prepareForExport(prepareCheck(check)));
    }
}