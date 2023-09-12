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

const HomeScreen = () => {
  return (
    <LinearGradient
      colors={["#66A6FF", "#89F7FE"]}
      style={{ flex: 1 }}
      start={{ x: 0, y: 0 }}
      end={{ x: 0, y: 1 }}
    >
      <SafeAreaView style={styles.AndroidSafeArea}>
        <View style={styles.container}>
          <View style={styles.header}>
            <Image source={require("../assets/infoButton.png")} />
            <Image source={require("../assets/settingsButton.png")} />
          </View>
          <View style={styles.tooltip}>
            <Image source={require("../assets/tooltip.png")}></Image>
          </View>
          <Image source={require("../assets/logo.png")} style={styles.logo} />
          <View style={styles.footer}>
            <Button title="Start" />
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
  container1: {
    flex: 1,
    width: "100%",
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
  tooltip: {
    position: "absolute",
    top: 0,
    right: 15,
  },
  logo: {
    marginBottom: "auto",
    marginTop: "auto",
    transform: [{ scale: 1.25 }],
  },
  footer: {
    position: "absolute",
    marginTop: "150%",
  },
});

export default HomeScreen;
