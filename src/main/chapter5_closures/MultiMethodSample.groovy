package chapter5_closures

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
class MultiMethodSample {
    int mysteryMethod (String value) {
        return value.length()
    }
    int mysteryMethod (List list) {
        return list.size()
    }
    int mysteryMethod (int x, int y) {
        return x+y
    }
}
