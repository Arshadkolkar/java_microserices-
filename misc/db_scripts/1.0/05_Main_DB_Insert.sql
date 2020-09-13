INSERT INTO public.sca_user(sca_user_id, company_name, email, first_name, last_name, password, phone_number, user_id, member_id, refresh_token, is_active) VALUES (1, 'sca', 'ssdctmp_sreedharm@protoexpress.com', 'sreedhar', 'm', '', '123456789', '0dc560fd-5140-341c-af55-d3964ae9e4a6','sreedhar', 'a59f9524-d0f3-11ea-8ef3-e61efce3867e', true);


INSERT INTO public.quote_cache_data(
	quote_cache_data_id, design_file, electrical_testing_cost, quote_request_json, 
	quote_response_price_matrix_json, wmq_id)
	VALUES (1, 'file://designfile', 120, '{ "arrayXDim": "10", "arrayYDim": "1.5", "boardQty1": "10", "boardQty2": "20", "boardQty3": "30", "boardQty4": "40", "arrays": "Yes", "boardsPerArray": "2", "controlledDielectric": "No", "controlledImpedance": "None", "counterBore": "No", "counterSink": "No", "edgePlating": "No", "electricalTesting": "No", "finishedThickness": "0.062 inches", "goldFingers": "No", "indBoardXDim": "4", "indBoardYDim": "2.25", "innerLyrFinishCopper": "1 oz Inners", "layers": "4 Layers", "material": "FR4", "minHoleSize": "0.006 inches", "minimumSpace": "0.012 Inches", "minimumSpaceInnerLyr": "0.004 Inches", "minimumTrace": "0.006 inches", "minimumTraceInnerLyr": "0.004 Inches", "noOfHolesPerBoard": "25", "outerLyrFinishCopper": "1 Oz", "partNumber": "SCA_Quote_Test_30", "partRevision": "1", "projectID": "SCA0001", "routeAndRetain": "No", "scoring": "No", "silkScreen": "Yes", "silkScreenColor": "Black", "silkScreenSides": "Top", "slotsCutouts": "None", "solderMask": "Yes", "solderMaskColor": "Green", "solderMaskFinish": "Standard (Semi-Gloss)", "solderMaskSides": "Top only", "solderMaskType": "LPI", "surfaceFinish": "HASL", "thruHoleViainPad": "No", "itar": "No", "vendorMarking": "Yes", "roHSMarking": "No" }
', '{
    "errorCode": "",
    "pcbPriceMatrixHeader": [
        "All files receive full CAM review and inspection to IPC-600, Class 2 standards.",
        "Finished hole tolerance +/- .003\" (if requested).",
        "We do not charge for NRE/Tooling. It is free! ",
        "Electrical Testing is optional for 1 to 6 layer boards. For boards with more than 6 layers, Electrical Testing is mandatory.",
        "Unit prices shown on price matrix do not include any Shipping charges or any applicable taxes.",
        "The Shipping charges we display for Web PCB orders are for up to a 1 lb. package. If your PCB/ Assembly shipment weight exceeds that we will add appropriate shipping charges in your final invoice."
    ],
    "webQuoteMatrix": [
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "2",
            "testingPrice": "140.00",
            "unitPrice": "165.62",
            "quantity": "10"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "3",
            "testingPrice": "140.00",
            "unitPrice": "103.60",
            "quantity": "10"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "4",
            "testingPrice": "140.00",
            "unitPrice": "92.30",
            "quantity": "10"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "5",
            "testingPrice": "140.00",
            "unitPrice": "83.31",
            "quantity": "10"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "2",
            "testingPrice": "140.00",
            "unitPrice": "85.31",
            "quantity": "20"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "3",
            "testingPrice": "140.00",
            "unitPrice": "52.83",
            "quantity": "20"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "4",
            "testingPrice": "140.00",
            "unitPrice": "47.07",
            "quantity": "20"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "5",
            "testingPrice": "140.00",
            "unitPrice": "42.47",
            "quantity": "20"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "2",
            "testingPrice": "140.00",
            "unitPrice": "58.54",
            "quantity": "30"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "3",
            "testingPrice": "140.00",
            "unitPrice": "35.92",
            "quantity": "30"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "4",
            "testingPrice": "140.00",
            "unitPrice": "31.98",
            "quantity": "30"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "5",
            "testingPrice": "140.00",
            "unitPrice": "28.86",
            "quantity": "30"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "2",
            "testingPrice": "140.00",
            "unitPrice": "56.24",
            "quantity": "40"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "3",
            "testingPrice": "140.00",
            "unitPrice": "27.95",
            "quantity": "40"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "4",
            "testingPrice": "140.00",
            "unitPrice": "24.95",
            "quantity": "40"
        },
        {
            "nreCharge": "0.00",
            "isCallUs": "0",
            "reasonForCallUs": "",
            "turntime": "5",
            "testingPrice": "140.00",
            "unitPrice": "27.84",
            "quantity": "40"
        }
    ],
    "pcbPriceMatrixFooter": "TOOLING NRE = $0.00 Free!",
    "wmqID": "WMQ45265-4"
}', 'WMQ45265-4');