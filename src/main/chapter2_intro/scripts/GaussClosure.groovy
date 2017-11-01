/**
 * Created by NM.Rabotaev on 18.10.2017.
 */

def totalClinks = 0
def partyPeople = 100
1.upto(partyPeople) { guestNumber ->
    clinksWithGuest = guestNumber - 1
    totalClinks += clinksWithGuest
}

// gauss formula equality assertion
println "Total clinks for $partyPeople guests is $totalClinks"
assert totalClinks == (partyPeople * (partyPeople - 1)) / 2
