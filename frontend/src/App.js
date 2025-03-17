
import React, { useEffect, useState } from "react";
import axios from "axios";

function App() {
  const [cars, setCars] = useState([]);

  useEffect(() => {
    axios.get("http://localhost:8080/api/cars") // Replace with your backend URL
      .then((response) => {
        setCars(response.data);
      })
      .catch((error) => {
        console.error("Error fetching cars:", error);
      });
  }, []);
  return (
    <div style={{ textAlign: "center", padding: "20px" }}>
      <h1>Car Rental Platform</h1>
      <ul>
        {cars.length > 0 ? (
          cars.map((car) => (
            <li key={car.id}>
              {car.brand} {car.model} - ${car.pricePerDay}/day
            </li>
          ))
        ) : (
          <p>No cars available</p>
        )}
      </ul>
    </div>
  );
}

export default App;

