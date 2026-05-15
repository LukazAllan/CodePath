package br.com.codepath.api.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class MatchingPair {
    private String left;
    private String right;
}

