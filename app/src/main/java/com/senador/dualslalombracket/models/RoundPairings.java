package com.senador.dualslalombracket.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RoundPairings {

    private List<Pairing> pairings = new ArrayList<>();

    /**
     * Creates an initial list of pairings for the fist round. Pairings are ordered by qualifying
     * times such as:
     *      1st - 8th
     *      3rd - 6th
     *      4th - 5th
     *      2nd - 3rd
     *
     * @param riders
     */
    public RoundPairings(List<Rider> riders, int numberOfQualifiers) {
        Collections.sort(riders);
        for (int i = 0; i < numberOfQualifiers; i+=2) {
            if (i < numberOfQualifiers / 2) {
                Rider highSeed = riders.get(i);
                Rider lowSeed = riders.get(numberOfQualifiers - i - 1);
                pairings.add(new Pairing(highSeed, lowSeed));
            } else {
                Rider highSeed = riders.get(numberOfQualifiers - i - 1);
                Rider lowSeed = riders.get(i);
                pairings.add(new Pairing(highSeed, lowSeed));
            }
        }
    }

    private RoundPairings(List<Pairing> pairings) {
        for (int i = 0; i < pairings.size(); i+=2) {
            Rider highSeed = pairings.get(i).getWinner();
            Rider lowSeed = pairings.get(i + 1).getWinner();
            this.pairings.add(new Pairing(highSeed, lowSeed));
        }
    }

    public RoundPairings createNextRound() {
        // Check if all pairings have a winner
        for (Pairing pairing : pairings) {
            if (pairing.getWinner() == null) {
                return null;
            }
        }
        return new RoundPairings(pairings);
    }

    public List<Pairing> getPairings() {
        return pairings;
    }

    public void setPairings(List<Pairing> pairings) {
        this.pairings = pairings;
    }
}
