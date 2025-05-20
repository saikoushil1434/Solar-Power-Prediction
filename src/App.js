import React, { useState } from "react";
import axios from "axios";

function App() {
  const [radiation, setRadiation] = useState("");
  const [powerOutput, setPowerOutput] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const input = {
      radiation: parseFloat(radiation),
      powerOutput: 0 // Dummy value; backend only uses radiation
    };

    try {
      const response = await axios.post("http://localhost:8080/api/predict", input);
      setPowerOutput(response.data);
    } catch (error) {
      console.error("Prediction failed:", error);
    }
  };

  return (
    <div style={{ padding: "20px" }}>
      <h2>Solar Power Predictor</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="number"
          step="any"
          placeholder="Enter Radiation"
          value={radiation}
          onChange={(e) => setRadiation(e.target.value)}
          required
        />
        <button type="submit">Predict</button>
      </form>
      {powerOutput !== null && (
        <div>
          <h4>Predicted Power Output: {powerOutput.toFixed(4)}</h4>
        </div>
      )}
    </div>
  );
}

export default App;
