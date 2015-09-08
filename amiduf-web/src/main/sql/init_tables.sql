CREATE TABLE saison
(
  id bigserial NOT NULL,
  libelle character varying(64) NOT NULL,
  CONSTRAINT saison_pkey PRIMARY KEY (id)
);