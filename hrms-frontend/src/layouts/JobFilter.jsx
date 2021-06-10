import React from "react";
import {
  Form,
  Icon,
  Segment,
  Header,
  Grid,
  Button,
  GridColumn,
  Container,
  Image,
  List,
} from "semantic-ui-react";

const options = [
  { key: "m", text: "YAKINDA", value: "YAKINDA" },
  { key: "f", text: "YAKINDA", value: "YAKINDA" },
  { key: "o", text: "YAKINDA", value: "YAKINDA" },
];

export default function FilterJob() {
  return (
    <div className="backgroundimagesirket">
      <Segment.Group>
        <Container>
          <Grid style={{ margin: "4em 0em 2em 0em", padding: "0em 0em 0em 0em" }}>
            <Grid.Row>
              <Grid.Column width={3}></Grid.Column>
              <Grid.Column width={13}>
                <List>
                  <List.Item>
                    <Image
                      size="massive"
                      src="https://www.ticimax.com/Uploads/images/sirket-nasil-kurulur-1-0f7379.jpg"
                      centered
                      rounded
                      bordered
                    />
                  </List.Item>
                  <List.Item
                    style={{
                      margin: "1em 0em 0em 0em",
                      padding: "0em 0em 0em 0em",
                    }}
                  >
                    <div className="font-family-librebasker">
                      <br />
                      <strong>Hayalinizdeki işi bulmak ister misiniz?</strong>
                    </div>
                  </List.Item>
                </List>
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </Container>

        <Segment inverted placeholder>
          <Container>
            <Form size="small">
              <Grid>
                <Grid.Row>
                  <Grid.Column width={3}></Grid.Column>
                  <Grid.Column width={13}>
                    <Grid columns={3} stackable textAlign="center">
                      <Grid.Row>
                        <Grid.Column>
                          <Header inverted icon>
                            <Icon name="road" />
                            City
                          </Header>
                          <Form.Field placeholder="City" />
                          <Form.Select
                            options={options}
                            placeholder="Şehir Seçiniz."
                            error
                          />
                        </Grid.Column>
                        <Grid.Column>
                          <Header inverted icon>
                            <Icon name="list layout" />
                            Job Position
                          </Header>
                          <Form.Field placeholder="Job Position" />
                          <Form.Select
                            options={options}
                            placeholder="İş Pozisyonu Seçiniz."
                            error
                          />
                        </Grid.Column>
                        <Grid.Column>
                          <Header inverted icon>
                            <Icon name="checkmark" />
                            Current Notice
                          </Header>
                          <Form.Field placeholder="Current Notice" />
                          <Form.Select
                            options={options}
                            placeholder="Pasif İlan Durumu."
                            error
                          />
                        </Grid.Column>
                      </Grid.Row>

                      <Grid.Row columns={4}>
                        <GridColumn>
                          <Button secondary size="huge">
                            <Icon name="search" />
                            Job Filtering
                          </Button>
                        </GridColumn>
                      </Grid.Row>
                    </Grid>
                  </Grid.Column>
                </Grid.Row>
              </Grid>
            </Form>
          </Container>
        </Segment>
      </Segment.Group>
    </div>
  );
}
