package chapter2_intro.scripts

import chapter2_intro.Book

/**
 * Created by NM.Rabotaev on 12.10.2017.
 */

Book gina = new Book('Groovy in Action')
assert gina.getTitle() == 'Groovy in Action'
assert getTitleBackwards(gina) == 'noitcA ni yvoorG'

String getTitleBackwards(Book book) {
    return book.getTitle().reverse()
}
