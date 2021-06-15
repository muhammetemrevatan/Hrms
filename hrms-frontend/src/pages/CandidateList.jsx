import React, { useState, useEffect } from "react";
import { Card, Container } from "semantic-ui-react";
import CandidateService from "../services/candidateService";

export default function CandidateList() {
  const [candidates, setCandidates] = useState([]);

  useEffect(() => {
    let candidateService = new CandidateService();
    candidateService.getCandidate().then((result) => setCandidates(result.data.data));
  }, []);

  return (
    <div>
      <Container style={{ margin: "2em 2em 0em 0em", padding: "2em 0em 2em 0em" }}>
        {candidates.map((candidate) => (
          <Card
            style={{ margin: "2em 2em 3em 1em", padding: "2em 0em 1em 2em" }}
            fluid
            key={candidate.id}
          >
            <Card.Content>
              <Card.Header>
                {candidate.firstName} {candidate.lastName}
              </Card.Header>
              <Card.Meta>Aday</Card.Meta>
              <Card.Description>
                {candidate.mail}
                <br />
                {candidate.birthDate}
              </Card.Description>
            </Card.Content>
          </Card>
        ))}
      </Container>
    </div>
  );
}
