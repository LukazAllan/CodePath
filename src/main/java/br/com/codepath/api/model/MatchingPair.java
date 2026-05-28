package br.com.codepath.api.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class MatchingPair {
    private String esq;
    private String dir;
}

