package learn.oop.acdpsp.ch07srp;

import learn.oop.acdpsp.ch06refactor.TradeRecord;

public interface TradeMapper {
    TradeRecord map(String[] data);
}
