import React from "react";
import {
  ScrollView,
  View,
  Text,
  SafeAreaView,
  Image,
  StyleSheet,
  Platform,
  StatusBar,
} from "react-native";
import { LinearGradient } from "expo-linear-gradient";
import Button from "../components/Button";

const ScoreScreen = ({ score, location }) => {
  let colors;
  let scoreImage;
  if (score == 0) {
    colors = ["#232526", "#3D2929", "#EF473A"];
    scoreImage = require("../assets/negative.png");
  } else if (score <= 24) {
    colors = ["#CB2D3E", "#E96B61"];
    scoreImage = require("../assets/negative.png");
  } else if (score <= 49) {
    colors = ["#FF5858", "#F09819"];
    scoreImage = require("../assets/negative.png");
  } else if (score <= 74) {
    colors = ["#FAC43B", "#F9E833"];
    scoreImage = require("../assets/positive.png");
  } else {
    colors = ["#39F3BB", "#90F9C4"];
    scoreImage = require("../assets/positive.png");
  }
  return (
    <LinearGradient
      colors={colors}
      style={{ flex: 1 }}
      start={{ x: 0, y: 0 }}
      end={{ x: 0, y: 1 }}
    >
      <SafeAreaView style={styles.AndroidSafeArea}>
        <View style={styles.container}>
          <View style={styles.header}>
            <Image source={require("../assets/backButton.png")} />
          </View>
          <View style={styles.scoreLocation}>
            <Image source={scoreImage}></Image>
            <Text style={styles.location}>{location}</Text>
            <Text style={styles.score}>{score}</Text>
          </View>
          <View style={styles.footer}>
            <Text style={styles.footerText}>What does this number mean?</Text>
            <Image source={require("../assets/scrolldown.png")}></Image>
          </View>
        </View>
      </SafeAreaView>
    </LinearGradient>
  );
};

const styles = StyleSheet.create({
  AndroidSafeArea: {
    flex: 1,
    paddingTop: Platform.OS === "android" ? StatusBar.currentHeight : 0,
  },
  container: {
    flex: 1,
    justifyContent: "flex-start",
    alignItems: "center",
    width: "100%",
  },
  header: {
    position: "absolute",
    flexDirection: "row",
    justifyContent: "space-between",
    marginTop: 10,
    paddingHorizontal: 20,
    width: "100%",
  },
  scoreLocation: {
    top: 50,
    justifyContent: "center",
    alignItems: "center",
  },
  location: {
    fontFamily: "Poppins-Bold",
    fontWeight: "bold",
    color: "white",
    textAlign: "center",
    fontSize: 20,
  },
  score: {
    top: 100,
    fontFamily: "Poppins-Bold",
    fontWeight: "bold",
    color: "white",
    textAlign: "center",
    fontSize: 200,
  },
  footer: {
    justifyContent: "center",
    alignItems: "center",
    top: 400,
  },
  footerText: {
    color: "white",
    fontSize: 20,
    fontWeight: "bold",
    marginBottom: 10,
  },
});

export default ScoreScreen;
