import React, { useState, useEffect } from "react";
import { Button, Card, Container, Image } from "semantic-ui-react";
import JobAdvertisementService from "../services/jobAdvertisementService";

export default function JobAdvertisementList() {
  const [jobAdvertisements, setJobAdvertisement] = useState([]);

  useEffect(() => {
    let jobAdvertisementService = new JobAdvertisementService();
    jobAdvertisementService
      .getJobAdvertisement()
      .then((result) => setJobAdvertisement(result.data.data));
  }, []);

  return (
    <div>
      <Container>
        {jobAdvertisements.map((jobAdvertisement) => (
          // Card start
          <Card
            fluid
            style={{ margin: "2em 2em 2em 1em", padding: "2em 0em 1em 2em" }}
            key={jobAdvertisement.id}
          >
            <Card.Content>
              <Image
                size="small"
                src="https://react.semantic-ui.com/images/avatar/large/elliot.jpg"
              />
            </Card.Content>
            <Card.Content>
              <Card.Header>{jobAdvertisement.jobPositionPosition}</Card.Header>
            </Card.Content>
            <Card.Content>
              <Card.Meta>Şehir : {jobAdvertisement.cityCity}</Card.Meta>
              <Card.Meta>
                Açıklama : {jobAdvertisement.jobDescription}
              </Card.Meta>
            </Card.Content>

            <Card.Content extra>
              <div className="ui two buttons">
                <Button basic color="green">
                  Başvur
                </Button>
                <Button basic color="blue">
                  İncele
                </Button>
              </div>
            </Card.Content>
          </Card>
          //Card end
        ))}
      </Container>
    </div>
  );
}
