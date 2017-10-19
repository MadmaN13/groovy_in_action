package chapter2

import groovy.transform.Immutable

/**
 * Created by NM.Rabotaev on 12.10.2017.
 */

// equals() is overridden explicitly by this annotation
@Immutable
class Money {
    int money
    String currency

    Money plus (Money other) {
        if (null == other) return this
        if (other.currency != currency) {
            throw new IllegalArgumentException("" +
                    "Cannot add $other.currency to $currency")
            return new Money(amount + other.amount, currency)
        }
    }
}