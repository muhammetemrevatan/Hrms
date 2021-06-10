import React, { useState, useEffect } from "react";
import { Card, Container } from "semantic-ui-react";
import EmployerService from "../services/employerService";

export default function EmployerList() {
  const [employers, setEmployers] = useState([]);

  useEffect(() => {
    let employerService = new EmployerService();
    employerService.getEmployer()
    .then((result) => setEmployers(result.data.data));
  }, []);

  return (
    <div>
      <Container>
        {employers.map((employer) => (
          <Card
            style={{ margin: "2em 2em 3em 1em", padding: "2em 0em 1em 2em" }}
            fluid
            key={employer.id}
          >
            <Card.Content>
              <Card.Header>
                {employer.companyName}
              </Card.Header>
              <Card.Meta>Aday</Card.Meta>
              <Card.Description>
                {employer.mail}
                <br />
                {employer.phoneNumber}
                <br />
                {employer.webAddress}
              </Card.Description>
            </Card.Content>
          </Card>
        ))}
      </Container>
    </div>
  );
}
