/**
 * Created by NM.Rabotaev on 19.10.2017.
 */

import chapter2_intro.Money

Money rouble = new Money(1, 'RUR')
assert rouble

// uses overridden equality
assert rouble == new Money(1, 'RUR')

// uses overridden +
assert buck + buck == new Money(2, 'RUR')