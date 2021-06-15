import React from "react";
import { Link } from "react-router-dom";
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
          <Grid style={{ margin: "5em 0em 2em 0em", padding: "0em 0em 0em 0em" }}>
            <Grid.Row>
              <Grid.Column >
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
        
        <Segment placeholder inverted> 
          <Container>
            <Form size="small">
              <Grid>
                <Grid.Row>
                  <Grid.Column>
                    <Grid columns={3} stackable textAlign="center">
                      <Grid.Row>
                        <Grid.Column>
                          <Header inverted icon>
                            <Icon name="road" />
                            <label>Şehir</label>
                          </Header>
                          <Form.Select
                            options={options}
                            placeholder="Seçiniz..."
                          />
                        </Grid.Column>
                        <Grid.Column>
                          <Header inverted icon>
                            <Icon name="list layout" />
                            <label>Job Position</label>
                          </Header>
                          <Form.Select
                            options={options}
                            placeholder="Seçiniz..."
                          />
                        </Grid.Column>
                        <Grid.Column>
                          <Header inverted icon>
                            <Icon name="checkmark" />
                            <label>Çalışma Tipi</label>
                          </Header>
                          <Form.Select
                            options={options}
                            placeholder="Seçiniz..."
                          />
                        </Grid.Column>
                      </Grid.Row>

                      <Grid.Row columns={4}>
                        <GridColumn >
                          <Button size="huge"   color='blue' basic>
                            <Icon name="search"  />
                            <label  as={Link}> <strong>Filtrele</strong> </label>
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
