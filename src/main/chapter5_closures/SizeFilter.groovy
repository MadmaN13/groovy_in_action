package chapter5_closures

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
class SizeFilter {
    Integer limit
    boolean sizeUpTo(String value) {
        return value.size() <= limit
    }
}
