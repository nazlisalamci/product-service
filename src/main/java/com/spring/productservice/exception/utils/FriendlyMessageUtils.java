package com.spring.productservice.exception.utils;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

import com.spring.productservice.enums.Language;
import com.spring.productservice.exception.enums.IFriendlyMessageCode;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@UtilityClass // final
public class FriendlyMessageUtils {

  private static final String RESOURCE_BUNDLE_NAME = "FriendlyMessage";
  private static final String SPACIAL_CHARACTER = "__";

  public static String getFriendlyMessage(Language language, IFriendlyMessageCode messageCode) {
    String messageKey = null;

    try {
      Locale locale = new Locale(language.name());
      ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
      messageKey = messageCode.getClass().getSimpleName() + SPACIAL_CHARACTER + messageCode;
      return resourceBundle.getString(messageKey);

    } catch (MissingResourceException e) {
      log.error("Friendly message not found for key {}", messageKey);
      return null;
    }
  }
}
