import time

import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.ie.webdriver import WebDriver

from selenium_utils import find_element, click_element, verify_text, verify_user, click_Login, click_toggle


@pytest.fixture
def browser():
    driver = webdriver.Chrome()
    driver.maximize_window()
    yield driver
    driver.quit()


def test_saucedemo_scenario(browser):
    # 1. Launch the URL
    browser.get("https://www.saucedemo.com/")

    # 2. Verify SWAG LABS is present on the Web Page
    verify_text(browser, By.CLASS_NAME, "login_logo", "Swag Labs")
    # 3. add user
    verify_user(browser, By.ID, "user-name", "standard_user")
    # 4. enter password

    verify_user(browser, By.ID, "password", "secret_sauce")
    # 5 click login
    click_Login(browser, By.ID, "login-button")
    # 6. Add any one item to cart
    click_element(browser, By.CLASS_NAME, "btn_inventory")

    # 7. Click on the right corner of the button and verify item is added to the cart
    # add_to_cart_button = find_element(browser, By.CLASS_NAME, "btn_inventory")
    # ActionChains(browser).move_to_element(add_to_cart_button).context_click().perform()
    time.sleep(2)
    # 8. adding cart
    cart_item = find_element(browser, By.ID, "shopping_cart_container")
    assert cart_item.text == "1"  # Assuming the cart displays the count of items added
    time.sleep(2)
    # add_to_cart_button = find_element(browser, By.XPATH, "/html/body/div/div/div/div[1]/div[1]/div[3]/a")
    cart_item.click()
    time.sleep(2)

    click_toggle(browser, By.ID, "react-burger-menu-btn")
    time.sleep(1)
    # 9. Click on the left corner of the button and click on LOGOUT button
    # ActionChains(browser).move_to_element(add_to_cart_button).move_by_offset(-50, 0).click().perform()
    logout_button = find_element(browser, By.ID, 'logout_sidebar_link')
    logout_button.click()

    time.sleep(10)