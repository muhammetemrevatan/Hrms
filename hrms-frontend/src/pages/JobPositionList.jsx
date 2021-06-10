import React, { useState, useEffect } from "react";
import { Card, Container } from "semantic-ui-react";
import JobPositionService from "../services/jobPositionService";

export default function JobPositionList() {
  const [jobPositions, setJobPositions] = useState([]);

  useEffect(() => {
    let jobPositionService = new JobPositionService();
    jobPositionService
      .getJobPosition()
      .then((result) => setJobPositions(result.data.data));
  }, []);

  return (
    <div>
      <Container>
        {jobPositions.map((jobPosition) => (
          <Card
            style={{ margin: "2em 2em 3em 1em", padding: "2em 0em 1em 2em" }}
            fluid
            key={jobPosition.id}
          >
            <Card.Content>
              <Card.Header>İş Pozisyonu {jobPosition.id}</Card.Header>
              <Card.Content>{jobPosition.position}</Card.Content>
            </Card.Content>
          </Card>
        ))}
      </Container>
    </div>
  );
}
