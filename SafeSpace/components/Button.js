import React from "react";
import { Text, StyleSheet, Pressable } from "react-native";

export default function Button(props) {
  const { onPress, title = "Save" } = props;
  return (
    <Pressable
      style={({ pressed }) => [
        styles.button,
        Platform.OS === "android" && pressed && styles.androidPressed,
      ]}
      onPress={onPress}
    >
      <Text style={styles.text}>{title}</Text>
    </Pressable>
  );
}

const styles = StyleSheet.create({
  button: {
    alignItems: "center",
    justifyContent: "center",
    paddingVertical: 12,
    paddingHorizontal: 32,
    borderRadius: 10,
    elevation: 0,
    backgroundColor: "rgba(220, 220, 220, 0.5)",
  },
  text: {
    fontSize: 16,
    lineHeight: 21,
    fontWeight: "bold",
    letterSpacing: 0.25,
    color: "white",
  },
  androidPressed: {
    backgroundColor: "rgba(220, 220, 220, 0.8)",
  },
});
