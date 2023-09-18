import { StatusBar } from "expo-status-bar";
import { StyleSheet, Text, View } from "react-native";
import HomeScreen from "./screens/HomeScreen";
import ScoreScreen from "./screens/ScoreScreen";
import LoadingScreen from "./screens/LoadingScreen";
import { useFonts } from "expo-font";

export default function App() {
  const [fontsLoaded] = useFonts({
    "Poppins-Bold": require("./assets/fonts/Poppins-Bold.ttf"),
  });

  console.log(fontsLoaded);

  if (!fontsLoaded) {
    return <LoadingScreen />;
  }
  return <ScoreScreen score={80} location={"Roosendaal"}></ScoreScreen>;
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: "#fff",
    alignItems: "center",
    justifyContent: "center",
  },
});
