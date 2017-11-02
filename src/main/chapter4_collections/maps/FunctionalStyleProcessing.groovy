package chapter4_collections.maps

/**
 * Created by NM.Rabotaev on 02.11.2017.
 */
def people = [peter: 40, paul: 30, mary: 20]
assert people
        .findAll{ _, age -> age < 35 }
        .collect{ name, _ -> name.toUpperCase() }
        .sort()
        .join(', ') == 'MARY, PAUL'
