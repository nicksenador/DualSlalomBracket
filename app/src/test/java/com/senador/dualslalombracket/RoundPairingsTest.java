package com.senador.dualslalombracket;

import com.senador.dualslalombracket.models.Pairing;
import com.senador.dualslalombracket.models.Rider;
import com.senador.dualslalombracket.models.RoundPairings;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;

public class RoundPairingsTest {

    private Rider rider1 = new Rider(401);
    private Rider rider2 = new Rider(402);
    private Rider rider3 = new Rider(403);
    private Rider rider4 = new Rider(404);
    private Rider rider5 = new Rider(405);
    private Rider rider6 = new Rider(406);
    private Rider rider7 = new Rider(407);
    private Rider rider8 = new Rider(408);
    private Rider rider9 = new Rider(409);


    @Test
    public void firstRoundPairingsWith2Qualifying() {
        RoundPairings roundPairings = new RoundPairings(createListOf9Riders(), 2);
        List<Pairing> pairings = roundPairings.getPairings();
        List<Pairing> expectedPairings = createListOf1Pairings();
        assertEquals(expectedPairings, pairings);
    }

    @Test
    public void firstRoundPairingsWith8Qualifying() {
        RoundPairings roundPairings = new RoundPairings(createListOf9Riders(), 8);
        List<Pairing> pairings = roundPairings.getPairings();
        List<Pairing> expectedPairings = createListOf4Pairings();
        assertEquals(expectedPairings, pairings);
    }

    @Test
    public void nextRoundPairingsWith8Qualifying() {
        RoundPairings roundPairings = new RoundPairings(createListOf9Riders(), 8);
        List<Pairing> pairings = roundPairings.getPairings();
        pairings.get(0).setWinner(Pairing.Winner.HIGHSEED);
        pairings.get(1).setWinner(Pairing.Winner.LOWSEED);
        pairings.get(2).setWinner(Pairing.Winner.HIGHSEED);
        pairings.get(3).setWinner(Pairing.Winner.LOWSEED);
        roundPairings.setPairings(pairings);
        RoundPairings nextRoundPairings = roundPairings.createNextRound();
        List<Pairing> actualNextRoundPairings = nextRoundPairings.getPairings();
        List<Pairing> expectedPairings = createPairingListOf4Winners();
        assertEquals(expectedPairings, actualNextRoundPairings);
    }

    @Test
    public void nextRoundPairingsWithoutWinners() {
        RoundPairings roundPairings = new RoundPairings(createListOf9Riders(), 8);
        List<Pairing> pairings = roundPairings.getPairings();
        pairings.get(0).setWinner(Pairing.Winner.HIGHSEED);
        pairings.get(1).setWinner(Pairing.Winner.LOWSEED);
        pairings.get(2).setWinner(Pairing.Winner.HIGHSEED);
        roundPairings.setPairings(pairings);
        RoundPairings nextRoundPairings = roundPairings.createNextRound();
        assertNull(nextRoundPairings);
    }

    private List<Rider> createListOf9Riders() {
        rider1.setQualifyingTime(2);
        rider2.setQualifyingTime(6);
        rider3.setQualifyingTime(3);
        rider4.setQualifyingTime(1);
        rider5.setQualifyingTime(7);
        rider6.setQualifyingTime(4);
        rider7.setQualifyingTime(0);
        rider8.setQualifyingTime(9);
        rider9.setQualifyingTime(8);
        List<Rider> riders = new ArrayList<>();
        riders.add(rider1);
        riders.add(rider2);
        riders.add(rider3);
        riders.add(rider4);
        riders.add(rider5);
        riders.add(rider6);
        riders.add(rider7);
        riders.add(rider8);
        riders.add(rider9);
        return riders;
    }

    private List<Pairing> createListOf4Pairings() {
        List<Pairing> pairings = new ArrayList<>();
        pairings.add(new Pairing(rider7, rider9));
        pairings.add(new Pairing(rider1, rider2));
        pairings.add(new Pairing(rider3, rider6));
        pairings.add(new Pairing(rider4, rider5));
        return pairings;
    }

    private List<Pairing> createListOf1Pairings() {
        List<Pairing> pairings = new ArrayList<>();
        pairings.add(new Pairing(rider7, rider4));
        return pairings;
    }

    private List<Pairing> createPairingListOf4Winners() {
        List<Pairing> pairings = new ArrayList<>();
        pairings.add(new Pairing(rider7, rider2));
        pairings.add(new Pairing(rider3, rider5));
        return pairings;
    }
}
